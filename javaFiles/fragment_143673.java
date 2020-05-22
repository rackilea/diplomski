try {
        dataHandler = new DataHandler(new File("/tmp/test.exe").toURL());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return new JaxbObjectResponse("id", dataHandler);