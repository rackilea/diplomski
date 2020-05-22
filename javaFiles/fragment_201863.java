abstract class Mixin<K, V> {
    public Mixin(@JsonProperty("key") K key, @JsonProperty("value") V value) {}        
} 
...
public static <T> T fromJSON(String content, Class<T> clazz) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.addMixInAnnotations(SimpleEntry.class, Mixin.class);
    return mapper.readValue(content, clazz);
}