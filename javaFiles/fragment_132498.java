public final class EntryPoint {

    private static final String JSON_WITH_SUBNODES = "{\"type\":\"node\",\"children\":[{\"id\":\"abc123\",\"name\":\"Name 1\",\"subdata\":{\"type\":\"node\",\"children\":[{\"id\":\"def456\",\"name\":\"Name 2\"}]}}]}";
    private static final String JSON_WITH_REFERENCES = "{\"type\":\"node\",\"children\":[{\"id\":\"abc123\",\"name\":\"Name 1\",\"subdata\":{\"type\":\"extra\",\"children\":[\"ghi\",\"jkl\",\"mno\"]}}]}";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Data.class, getDataJsonDeserializer())
            .create();

    public static void main(final String... args) {
        process(gson.fromJson(JSON_WITH_SUBNODES, Data.class));
        process(gson.fromJson(JSON_WITH_REFERENCES, Data.class));
    }

    private static void process(final Data data) {
        process(data, 0);
        out.println();
    }

    private static void process(final Data data, final int level) {
        for ( int i = 0; i < level; i++ ) {
            out.print('>');
        }
        final List<?> children = data.getChildren();
        final Type type = data.getType();
        out.println(type);
        switch ( type ) {
        case NODE:
            @SuppressWarnings("unchecked")
            final Iterable<Node> nodeChildren = (Iterable<Node>) children;
            for ( final Node node : nodeChildren ) {
                out.printf("\t%s %s\n", node.getId(), node.getName());
                final Data subdata = node.getSubdata();
                if ( subdata != null ) {
                    process(subdata, level + 1);
                }
            }
            break;
        case EXTRA:
            @SuppressWarnings("unchecked")
            final Iterable<String> extraChildren = (Iterable<String>) children;
            for ( final String extra : extraChildren ) {
                out.printf("\t%s\n", extra);
            }
            break;
        default:
            throw new AssertionError(type);
        }
    }

}