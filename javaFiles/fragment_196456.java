try {
    InputStream in = servletContext.getResourceAsStream(taggerModelPath);
    POSModel posModel;
    if(in != null) {
        posModel = new POSModel(in);

        // from here, <posModel> is initialized and you can start playing with it...
        // ...
    }
    else {
        // resource file not found - whatever you want to do in this case
    }
}
catch (IOException | InvalidFormatException ex) {
    // proper exception handling here... cause: getResourcesAsStream or OpenNLP...
}