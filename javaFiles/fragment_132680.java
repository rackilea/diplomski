Map<MyEnum, String> mymap = new EnumMap<>(MyEnum.class);

public void addProperty(MyEnum key, Object value) {
    mymap.put(key, value);
}

@JsonAnySetter
private void addProperty(String key, Object value) {
    addProperty(MyEnum.valueOf(key), value);
}