while (urls.hasMoreElements()) {
        URL url = urls.nextElement();
        if (url.getProtocol().equals("file")) {
            ...
        }
    }