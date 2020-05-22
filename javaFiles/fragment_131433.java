final SpeechToText service = new SpeechToText();
            service.setUsernameAndPassword("<YourUsername>", "<Password>");

            final File audio = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/about_time.wav");

            final RecognizeOptions options = new RecognizeOptions.Builder()
                    .continuous(false)
                    .model("en-US_NarrowbandModel")
                    .interimResults(true)
                    .contentType(HttpMediaType.AUDIO_WAV)
                    .build();



            new Thread(new Runnable() {
                public void run() {
                    SpeechResults transcript = service.recognize(audio, options).execute();
                    System.out.println(transcript);
                }
            }).start();