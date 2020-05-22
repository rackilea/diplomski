public void remove(String str) {
    final String uri = "http://hostName/local/{str}";
    Map<String, String> params = new HashMap<String, String>();
    params.put("str", "my_String");

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(uri, String.class, params);
}