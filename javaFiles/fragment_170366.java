class Builder {

private final String id;
private final String type;

private Map<String, Integer> map = new HashMap<>();

// mandatory fields are always passed through constructor 
Builder(String id, String type) {
    this.id = id;
    this.type = type;
}

Builder typeAndCount(String type, int count) {
    map.put(type, count);
    return this;
}

JsonObject toJson() {

    JsonObjectBuilder internal = null;
    if (!map.isEmpty()) {
        internal = Json.createObjectBuilder();
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            internal.add(e.getKey(), e.getValue());
        }
    }
    // mandatory fields
    JsonObjectBuilder ob = Json.createObjectBuilder()
            .add("id", id)
            .add("type", type);

    if (internal != null) {
        ob.add("makers", Json.createObjectBuilder().add("typesAndCount", internal));
    }
    return ob.build();
}

public static void main(String[] args) {
    Builder b = new Builder("id_value", "type_value")
            .typeAndCount("abs", 1)
            .typeAndCount("rty", 2);

    String result = b.toJson().toString();
    System.out.println(result);
}
}