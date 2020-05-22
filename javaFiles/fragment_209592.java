recognizer = SpeechRecognizerSetup.defaultSetup()
            .setAcousticModel(new File(assetsDir, "en-us-ptm"))
            .setDictionary(new File(assetsDir, "cmudict-en-us.dict"))
            .getRecognizer();

    recognizer.addListener(mRecognitionListener);
    recognizer.getDecoder().setRawdataSize(300000);// don't forget to set size

    recognizer.addKeyphraseSearch(KWS_SEARCH, KEYPHRASE);


}