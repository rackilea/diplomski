Session session = Session.Factory.session(this, com.intellidev.mobitranscribe.Configuration.SERVER_URI,
                com.intellidev.mobitranscribe.Configuration.APP_KEY);

        Transaction.Options options = new Transaction.Options();
        options.setRecognitionType(RecognitionType.DICTATION);
        options.setDetection(DetectionType.Long);
        options.setLanguage(new Language("ENG-USA"));

        //Start listening
        recoTransaction = speechSession.recognize(options, recoListener);