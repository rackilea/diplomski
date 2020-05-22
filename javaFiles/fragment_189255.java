private static final class MappingErrors {

    private Map<String, String> map = new HashMap<>();

    private String first, second;

    public void accept(String str) {
        first = second;
        second = str;
        if (first != null && first.startsWith("err")) {
            map.put(first, second);
        }
    }

    public MappingErrors combine(MappingErrors other) {
        throw new UnsupportedOperationException("Parallel Stream not supported");
    }

    public Map<String, String> finish() {
        return map;
    }

    public static Collector<String, ?, Map<String, String>> collector() {
        return Collector.of(MappingErrors::new, MappingErrors::accept, MappingErrors::combine, MappingErrors::finish);
    }

}