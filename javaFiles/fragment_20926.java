URL url = getClass().getClassLoader().getResource(path);
        if(url != null) {
            try {
                return new File(url.toURI().getPath());
            } catch (URISyntaxException e) {
                return null;
            }
        }