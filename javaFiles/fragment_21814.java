public NewsSource getNewsSource() {
    String URL = source_url;

    NewsSource newsSource =null;
    try {
        /*
        String result = restTemplate.getForObject(URL, String.class);
        ObjectMapper mapper = new ObjectMapper();

        newsSource= (NewsSource) getJsonObject(result);
        System.out.println("done:" +newsSource);
        */

        newsSource = restTemplate.getForObject(URL, NewsSource.class);
        System.out.println("done:" + newsSource.toString());
    } catch (Exception ex){
        System.out.println("oooh exception \n" + ex);
    }

    return newsSource;
}