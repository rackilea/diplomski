public class ComputeExpressionTreeConverter extends TypeConverter implements SimpleValueConverter {

    public ComputeExpressionTreeConverter() {
        super(ComputeExpTraversalTree.class);
    }

    @Override
    public Object encode(Object value, MappedField optionalExtraInfo) {
        if (value == null) {
            return null;
        }
        DBObject dbo = null;
        String expressionTree=new Gson().toJson(
                value, ComputeExpTraversalTree.class);
        dbo=BasicDBObject.parse(expressionTree);
        return dbo;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Object decode(Class targetClass, Object fromDBObject, MappedField field) throws MappingException {
        if (fromDBObject == null) {
            return null;
        }
        DBObject dbo = (DBObject) fromDBObject;
        JsonElement jsonElement = new JsonParser().parse(dbo.toString());
        ComputeExpTraversalTree expTraversalTree = new Gson().fromJson(
                jsonElement, ComputeExpTraversalTree.class);
        return expTraversalTree;
    }

}