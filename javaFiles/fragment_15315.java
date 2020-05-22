PitchDetectionHandler handler = new PitchDetectionHandler() {
        @Override
        public void handlePitch(PitchDetectionResult pitchDetectionResult,
                AudioEvent audioEvent) {
            System.out.println(audioEvent.getTimeStamp() + " " pitchDetectionResult.getPitch());
        }
    };
    AudioDispatcher adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
    adp.run();