public void callingMethod() {
    Map<String, Object> params = ImmutableMap.of(
        "param1Name", param1Value,
        "param2Name", param2Value,
    );
    makeRequest(params);
}

public void makeRequest(Map<String, Object> params) {
    HttpPost request = new HttpPost(url);
    request.addHeader("Content-Type", "application/json");
    request.setEntity(new Gson().toJson(params)));
}