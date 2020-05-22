public class NewDeserializer extends StdDeserializer<Object> {
    private final StdDeserializer<Object> oldDeserializer;

    NewDeserializer(final StdDeserializer<Object> oldDeserializer) {
        super(NewObject.class);
        this.oldDeserializer = oldDeserializer;
    }

    @Override
    public Object deserialize(
            final JsonParser parser,
            final DeserializationContext context) throws IOException {
       final ObjectCodec codec = parser.getCodec();

       // Read the JSON document to a tree
       final TreeNode treeNode = codec.readTree(parser);

       // Identify if it is the new format, or the old one
       final TreeNode newField = treeNode.get("newField");

       if (newField == null) {
          // Delegate to the old de-serializer
          final JsonFactory factory = new JsonFactory(parser.getCodec());
          final JsonParser oldParser = factory.createParser(treeNode.toString());
          return oldDeserializer.deserialize(oldParser, context);
       }

       return codec.readValue(treeNode.traverse(), NewObject.class);
    }
}