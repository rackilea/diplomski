public MovieSearchResults search(String query) {
    return client
        .register(JsonContentTypeResponseFilter.class)
        .target("http://api.rottentomatoes.com/api/public/v1.0/movies.json")
        .queryParam("apikey", API_KEY)
        .queryParam("q", query)
        .request(MediaType.APPLICATION_JSON)
        .get(MovieSearchResults.class);
}