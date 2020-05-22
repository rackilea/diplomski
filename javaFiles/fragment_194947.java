@Data
@AllArgsConstructor
@NoArgsConstructor
public static class DummyUser {
    private String userName;

    @JsonProperty("user_name")
    public setUserName(String un) {...}
}

ObjectMapper mapper = new ObjectMapper();

Map<String, String> myMap = new LinkedHashMap<>();
myMap.put("user_name", "John Doe");

mapper.readValue(myMap, DummyUser.class);