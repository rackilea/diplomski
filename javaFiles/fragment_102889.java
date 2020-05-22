RecognitionConfig config =
      RecognitionConfig.newBuilder()
          .setEncoding(AudioEncoding.LINEAR16)
          .setSampleRate(samplingRate)
          .setLanguageCode("en-US")
          .build();