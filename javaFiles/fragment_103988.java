public void doRecordingDemo() {

        // Get the default media capture device for audio and video
        DataSource[] sources = new DataSource[2];
        sources[0] = Manager.createDataSource(audioDevice.getLocator());
        sources[1] = Manager.createDataSource(videoDevice.getLocator());

        // Merge the audio and video streams
        DataSource source = Manager.createMergingDataSource(sources);

        // Create a processor to convert from raw format to a file format
        // Notice that we are NOT starting the datasources, but letting the
        //  processor take care of this for us.
        Processor processor = Manager.createProcessor(source);

        // Need a configured processor for this next step
        processor.configure();
        waitForState(processor, Processor.Configured);

        // Modify this to suit your needs, but pay attention to what formats can go in what containers
        processor.setContentDescriptor(new FileTypeDescriptor(FileTypeDescriptor.QUICKTIME));

        // Use the processor to convert the audio and video into reasonable formats and sizes
        // There are probably better ways to do this, but you should NOT make any assumptions
        // about what formats are supported, and instead use a generic method of checking the
        // available formats and sizes.  You have been warned!
        for (TrackControl control : processor.getTrackControls()) {
            if (control.getFormat() instanceof VideoFormat || control.getFormat() instanceof AudioFormat) {
                if (control.getFormat() instanceof AudioFormat) {
                    // In general, this is safe for audio, but do not make assumptions for video.
                    // Things get a little wonky for video because of how complex the options are.
                    control.setFormat(new AudioFormat(AudioFormat.GSM));
                }

                if (control.getFormat() instanceof VideoFormat) {
                    VideoFormat desiredVideoFormat = null;
                    Dimension targetDimension = new Dimension(352, 288);

                    // Search sequentially through this array of formats
                    VideoFormat[] desiredFormats = new VideoFormat[] {new H263Format(), new JPEGFormat(), new RGBFormat(), new YUVFormat()};
                    for (VideoFormat checkFormat : desiredFormats) {
                        // Search the video formats looking for a match.
                        List<VideoFormat> candidates = new LinkedList<VideoFormat>();
                        for (Format format : control.getSupportedFormats()) {
                            if (format.isSameEncoding(checkFormat)) {
                                candidates.add((VideoFormat) format);
                            }
                        }
                        if (!candidates.isEmpty()) {
                            // Get the first candidate for now since we have at least a format match
                            desiredVideoFormat = candidates.get(0);

                            for (VideoFormat format : candidates) {
                                if (targetDimension.equals(format.getSize())) {
                                    // Found exactly what we're looking for
                                    desiredVideoFormat = format;
                                    break;
                                }
                            }
                        }

                        if (desiredVideoFormat != null) {
                            // If we found a match, stop searching formats
                            break;
                        }
                    }

                    if (desiredVideoFormat != null) {
                        // It's entirely possible (but not likely) that we got here without a format
                        //  selected, so this null check is unfortunately necessary.
                        control.setFormat(desiredVideoFormat);
                    }
                }
                control.setEnabled(true);
                System.out.println("Enabled track: " + control + " (" + control.getFormat() + ")");
            }

        }

        // To get the output from a processor, we need it to be realized.
        processor.realize();
        waitForState(processor, Processor.Realized);

        // Get the data output so we can output it to a file.
        DataSource dataOutput = processor.getDataOutput();

        // Create a file to receive the media
        File answerFile = new File("recording.mov");
        MediaLocator dest = new MediaLocator(answerFile.toURI().toURL());

        // Create a data sink to write to the disk
        DataSink answerSink = Manager.createDataSink(dataOutput, dest);

        // Start the processor spinning
        processor.start();

        // Open the file
        answerSink.open();

        // Start writing data
        answerSink.start();

        // SUCCESS!  We are now recording
        Thread.sleep(10000);  // Wait for 10 seconds so we record 10 seconds of video

        try {
            // Stop the processor. This will also stop and close the datasources
            processor.stop();
            processor.close();

            try {
                // Let the buffer run dry.  Event Listeners never seem to get called,
                // so this seems to be the most effective way.
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }

            try {
                // Stop recording to the file.
                answerSink.stop();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                // Whatever else we do, close the file if we can to avoid leaking.
                answerSink.close();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }

            try {
                // Deallocate the native processor resources.
                processor.deallocate();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
}

// My little utility function to wait for a given state.
private void waitForState(Player player, int state) {
    // Fast abort
    if (player.getState() == state) {
        return;
    }

    long startTime = new Date().getTime();

    long timeout = 10 * 1000;

    final Object waitListener = new Object();

    ControllerListener cl = new ControllerListener() {

        @Override
        public void controllerUpdate(ControllerEvent ce) {
            synchronized (waitListener) {
                waitListener.notifyAll();
            }
        }
    };
    try {
        player.addControllerListener(cl);

        // Make sure we wake up every 500ms to check for timeouts and in case we miss a signal
        synchronized (waitListener) {
            while (player.getState() != state && new Date().getTime() - startTime < timeout) {
                try {
                    waitListener.wait(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } finally {
        // No matter what else happens, we want to remove this
        player.removeControllerListener(cl);
    }
}