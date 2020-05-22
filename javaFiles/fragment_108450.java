public class XmlIdGenerator {
    private HashSet<String> used;

    // provides a unique ID
    public String generate(String s) {
        String base = toSafeId(s);
        String id = base;
        for (int i = 1; used.contains(id); i++) {
            id = base + "-" + i;
        }
        used.add(id);
        return id;
    }
}