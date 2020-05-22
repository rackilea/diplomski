static class MapWrapper {
    @JsonDeserialize(keyUsing = MyCustomKeyDeserializer.class)
    private Map<Long, String> map1;
    @JsonDeserialize(keyUsing = MyCustomKeyDeserializer.class)
    private Map<Long, String> map2;
}