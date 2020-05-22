@Value("${appA.baseUrl}")
String appABaseUrl;

public List<Article> getArticles() {
        String url = appABaseUrl + "/article/getAllArticles/";
        HttpEntity entity = prepareHttpEntity();
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        return response.getBody();
}