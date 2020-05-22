public class CustomChangeSet extends ChangeSet {

/**
 * @param databaseChangeLog
 */
public CustomChangeSet(DatabaseChangeLog databaseChangeLog) {
    super(databaseChangeLog);
}

public CustomChangeSet(String id, String author, boolean alwaysRun,
        boolean runOnChange, String filePath, String contextList,
        String dbmsList, DatabaseChangeLog databaseChangeLog) {
    super(id, author, alwaysRun, runOnChange, filePath, contextList,
            dbmsList, databaseChangeLog);
}

public CustomChangeSet(String id, String author, boolean alwaysRun,
        boolean runOnChange, String filePath, String contextList,
        String dbmsList, boolean runInTransaction,
        DatabaseChangeLog databaseChangeLog) {
    super(id, author, alwaysRun, runOnChange, filePath, contextList,
            dbmsList, runInTransaction, databaseChangeLog);
}


public CustomChangeSet(String id, String author, boolean alwaysRun,
        boolean runOnChange, String filePath, String contextList,
        String dbmsList, ObjectQuotingStrategy quotingStrategy,
        DatabaseChangeLog databaseChangeLog) {
    super(id, author, alwaysRun, runOnChange, filePath, contextList,
            dbmsList, quotingStrategy, databaseChangeLog);
}

public CustomChangeSet(String id, String author, boolean alwaysRun,
        boolean runOnChange, String filePath, String contextList,
        String dbmsList, boolean runInTransaction,
        ObjectQuotingStrategy quotingStrategy,
        DatabaseChangeLog databaseChangeLog) {
    super(id, author, alwaysRun, runOnChange, filePath, contextList,
            dbmsList, runInTransaction, quotingStrategy, databaseChangeLog);
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializedObjectName()
 */
@Override
public String getSerializedObjectName() {
    return super.getSerializedObjectName();
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializableFields()
 */
@Override
public Set<String> getSerializableFields() {
    final Set<String> tables = super.getSerializableFields();
    tables.add("preconditions");
    return tables;
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializableFieldType(java.lang.String)
 */
@Override
public SerializationType getSerializableFieldType(String field) {
    if ("preconditions".equals(field)){
        return SerializationType.NESTED_OBJECT;
    }
    return super.getSerializableFieldType(field);
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializedObjectNamespace()
 */
@Override
public String getSerializedObjectNamespace() {
    return super.getSerializedObjectNamespace();
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializableFieldNamespace(java.lang.String)
 */
@Override
public String getSerializableFieldNamespace(String field) {
    return super.getSerializableFieldNamespace(field);
}

/**
 * {@inheritDoc}
 * @see liquibase.changelog.ChangeSet#getSerializableFieldValue(java.lang.String)
 */
@Override
public Object getSerializableFieldValue(String field) {
    if (field.equals("preconditions")){
        if (getPreconditions() != null){
            return new PreconditionContainerChange(getPreconditions());
        }else{
            return null;
        }
    }
    return super.getSerializableFieldValue(field);
}