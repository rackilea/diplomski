public class YourClass {

    private static final Logger LOGGER = Logger
            .getLogger(YourClass.class.getName());

    public final static ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T toTypedObject(Class<T> type, JsonNode tree) {
        return toTypedObject(type, tree, true);
    }

    private static <T> T toTypedObject(Class<T> type, JsonNode tree,
            boolean topLevel) {

        T object;

        try {
            object = mapper.treeToValue(tree, type);
        } catch (MismatchedInputException e) {
            String originalTree = tree.toString();
            object = toTypedObject(type, tree, originalTree, e);
            if (topLevel) {
                LOGGER.log(Level.WARNING, "Failed to convert node tree to a "
                        + type.getSimpleName()
                        + " object without modifications: " + originalTree, e);
                LOGGER.log(Level.INFO,
                        "Modified node tree was successfully converted to a "
                                + type.getSimpleName() + " object: " + tree);
            }
        } catch (JsonProcessingException e) {
            throw new YourException("Failed to convert node tree to a "
                    + type.getSimpleName() + " object: " + tree, e);
        }

        return object;
    }

    private static <T> T toTypedObject(Class<T> type, JsonNode tree,
            String originalTree,
            MismatchedInputException mismatchedInputException) {

        T object;

        List<Reference> path = mismatchedInputException.getPath();
        if (path != null && !path.isEmpty()) {

            try {

                ObjectNode subNode = (ObjectNode) tree;
                for (int i = 0; i < path.size(); i++) {
                    String fieldName = path.get(i).getFieldName();
                    if (i + 1 < path.size()) {
                        subNode = (ObjectNode) tree.get(fieldName);
                    } else {
                        subNode.remove(fieldName);
                    }
                }
                object = toTypedObject(type, tree, false);

            } catch (Exception e) {
                throw new YourException("Failed to convert node tree to a "
                        + type.getSimpleName() + " object: " + originalTree,
                        mismatchedInputException);
            }

        } else {
            throw new YourException(
                    "Failed to convert node tree to a " + type.getSimpleName()
                            + " object: " + originalTree,
                    mismatchedInputException);
        }

        return object;
    }

}