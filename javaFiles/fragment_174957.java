public class Rule {
    public List<String> parts;
    public String result;

    public Rule(String result, String... parts) {
        this.parts = new ArrayList<>();
        for(String part : parts) {
            this.parts.add(part);
        }
        this.result = result;
    }

    public String match(String line) {
        for(String part : parts) {
            if (!line.contains(part)) return null;
        }
        return result;
    }
}