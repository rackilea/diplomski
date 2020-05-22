public static HttpEntity<Object> createLMIHttpEntity(String username,
        String password, String lastSyncDate, String pageSize,
        String pageNumber) {
    MultiValueMap<String, String> headers =
            new LinkedMultiValueMap<String, String>();
        headers.add("Accept", "application/json");
        headers.add("userName", username);
        headers.add("password", password);
        headers.add("lastSyncDate", lastSyncDate);
        headers.add("pageSize", pageSize);
        headers.add("pageNumber", pageNumber);
        return new HttpEntity<Object>(headers);
}