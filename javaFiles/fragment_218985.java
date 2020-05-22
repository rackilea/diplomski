mAssistant = new Assistant("2018-02-16");
Map<String, String> map = new HashMap<>();
map.put("X-Watson-Authorization-Token", "{token_string}");
mAssistant.setDefaultHeaders(map);
mAssistant.setSkipAuthentication(true);

// change here
mAssistant.setEndPoint("https://gateway.watsonplatform.net/conversation/api");