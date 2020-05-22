try {
        String u = "http://webapi.com/demo.zip";
        URL url = new URL(u);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }