AudioRecorder recorder = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION,
            RECORDER_SAMPLERATE, RECORDER_CHANNELS,
            RECORDER_AUDIO_ENCODING, bufferSize);

    recorder.startRecording();
  AudioDispatcher dispatcher = com.example.revertback.AudioDispatcherFactory.fromDefaultMicrophone(recorder,22050,1024,0);


    PitchDetectionHandler pdh = new PitchDetectionHandler() {
        @Override
        public void handlePitch(PitchDetectionResult result, AudioEvent e) {
            final float pitchInHz = result.getPitch();

        }
    };
    AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
    dispatcher.addAudioProcessor(p);
    new Thread(dispatcher,"Audio Dispatcher").start();