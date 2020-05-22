public class PreconditionContainerChange implements LiquibaseSerializable {

/**
 * The precondition
 */
private PreconditionContainer preconditions;

/**
 * @param preconditions
 */
public PreconditionContainerChange(PreconditionContainer preconditions) {
    super();
    this.preconditions = preconditions;
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializedObjectName()
 */
@Override
public String getSerializedObjectName() {
    return "preConditions";
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializableFields()
 */
@Override
public Set<String> getSerializableFields() {
    return preconditions.getSerializableFields();
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializableFieldValue(java.lang.String)
 */
@Override
public Object getSerializableFieldValue(String field) {
    return preconditions.getSerializableFieldValue(field);
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializableFieldType(java.lang.String)
 */
@Override
public SerializationType getSerializableFieldType(String field) {
    return preconditions.getSerializableFieldType(field);
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializableFieldNamespace(java.lang.String)
 */
@Override
public String getSerializableFieldNamespace(String field) {
    return preconditions.getSerializableFieldNamespace(field);
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#getSerializedObjectNamespace()
 */
@Override
public String getSerializedObjectNamespace() {
    return preconditions.getName();
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#load(liquibase.parser.core.ParsedNode, liquibase.resource.ResourceAccessor)
 */
@Override
public void load(ParsedNode parsedNode, ResourceAccessor resourceAccessor)
        throws ParsedNodeException {
    preconditions.load(parsedNode, resourceAccessor);
}

/**
 * {@inheritDoc}
 * @see liquibase.serializer.LiquibaseSerializable#serialize()
 */
@Override
public ParsedNode serialize() throws ParsedNodeException {
    return preconditions.serialize();
}