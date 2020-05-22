public String make() throws IOException, InterruptedException {
        BufferedImage s1 = genImage();
        writer = ToolFactory.makeWriter("temp/" + sermon.getFile().getName() + ".flv");

        String filename = sermon.getFile().getAbsolutePath();
        IContainer container = IContainer.make();

        if (container.open(filename, IContainer.Type.READ, null) < 0) {
            throw new IllegalArgumentException("could not open file: " + filename);
        }
        int numStreams = container.getNumStreams();

        int audioStreamId = -1;
        IStreamCoder audioCoder = null;
        for (int i = 0; i < numStreams; i++) {
            IStream stream = container.getStream(i);
            IStreamCoder coder = stream.getStreamCoder();
            if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {
                audioStreamId = i;
                audioCoder = coder;
                break;
            }
        }
        if (audioStreamId == -1) {
            throw new RuntimeException("could not find audio stream in container: " + filename);
        }

        if (audioCoder.open() < 0) {
            throw new RuntimeException("could not open audio decoder for container: " + filename);
        }
        writer.addAudioStream(0, 0, audioCoder.getChannels(), audioCoder.getSampleRate());
        writer.addVideoStream(1, 1, width, height);
        IPacket packet = IPacket.make();
        int n = 0;
        while (container.readNextPacket(packet) >= 0) {
            n++;

            if (packet.getStreamIndex() == audioStreamId) {
                IAudioSamples samples = IAudioSamples.make(2048, audioCoder.getChannels());
                int offset = 0;
                while (offset < packet.getSize()) {
                    try {
                        int bytesDecoded = audioCoder.decodeAudio(samples, packet, offset);
                        if (bytesDecoded < 0) {
                            //throw new RuntimeException("got error decoding audio in: " + filename);
                            break;
                        }
                        offset += bytesDecoded;

                        if (samples.isComplete()) {
                            if (n % 1000 == 0) {
                                writer.flush();
                                System.out.println(n);
                                System.gc();
                            }
                            writer.encodeAudio(0, samples);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                do {
                } while (false);
            }
        }
        for (int i = 0; i < container.getDuration() / 1000000; i++) {
            writer.encodeVideo(1, s1, i, TimeUnit.SECONDS);
        }

        writer.close();

        if (audioCoder != null) {
            audioCoder.close();
            audioCoder = null;
        }
        if (container != null) {
            container.close();
            container = null;
        }
        return "temp/" + sermon.getFile().getName() + ".flv";
    }