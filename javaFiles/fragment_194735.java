Map<String, User> userMap = new HashMap<String, User>();
userMap.put("user", user);
String json = "";

try {
    json = objectMapper.writeValueAsString(userMap);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}