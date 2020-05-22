@Override
public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException
{
    JavaType valueType = ((MapType) typeHint).getContentType();
    visitor.getProvider().findValueSerializer(valueType).acceptJsonFormatVisitor(visitor, valueType);
}