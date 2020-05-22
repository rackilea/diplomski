public class SomeClass {
    // could (should?) be initialized in the ctor
    private Map<String, Integer> map = new HashMap<>();

    public void setInt (String identifier, int value) {
        // This assumes identifier != null, for clarity
        map.put (identifier, value);
    }

    public int getInt (String identifier) {
        return map.get (identifier);
}