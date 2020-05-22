try {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=århus,&mode=xml&units=metric";
        URI uri = new URI(url);
        URL escapedUrl = new URL(uri.toASCIIString());
    } catch (URISyntaxException e) {
        // handle exception
    } catch (MalformedURLException e) {
       // handle exception
    }