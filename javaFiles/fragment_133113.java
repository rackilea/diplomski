import liquibase.database.Database;
import liquibase.exception.CustomPreconditionErrorException;
import liquibase.exception.CustomPreconditionFailedException;
import liquibase.precondition.CustomPrecondition;
import liquibase.snapshot.SnapshotGeneratorFactory;
import liquibase.structure.core.ForeignKey;
import liquibase.structure.core.Schema;
import liquibase.structure.core.Table;
import liquibase.util.StringUtils;

/**
 * {@link CustomPrecondition} implementation that checks if a column on a table
 * has a foreign key constraint for some other table.
 */
public final class CheckForeignKey implements CustomPrecondition {

    /**
     * Schema.
     */
    private String schemaName;

    /**
     * Table name (that has the column).
     */
    private String tableName;

    /**
     * Column (that might have the foreign key).
     */
    private String columnName;

    /**
     * Referenced table of the foreign key.
     */
    private String foreignTableName;

    @Override
    public void check(final Database db)
            throws CustomPreconditionFailedException,
            CustomPreconditionErrorException {

        try {
            // The fkey we are looking for
            final ForeignKey fKey = new ForeignKey();

            // Schema, base table
            fKey.setForeignKeyTable(new Table());
            if (StringUtils.trimToNull(getTableName()) != null) {
                fKey.getForeignKeyTable().setName(getTableName());
            }

            final Schema schema = new Schema();
            schema.setName(getSchemaName());
            fKey.getForeignKeyTable().setSchema(schema);

            // Base column
            fKey.addForeignKeyColumn(getColumnName());

            // Referenced table
            fKey.setPrimaryKeyTable(new Table());
            if (StringUtils.trimToNull(getForeignTableName()) != null) {
                fKey.getPrimaryKeyTable().setName(getForeignTableName());
            }

            if (!SnapshotGeneratorFactory.getInstance().has(fKey, db)) {
                throw new CustomPreconditionFailedException(
                        String.format(
                                "Error fkey not found schema %s table %s column %s ftable %s",
                                getSchemaName(), getTableName(),
                                getColumnName(), getForeignTableName()));
            }
        } catch (final CustomPreconditionFailedException e) {
            throw e;
        } catch (final Exception e) {
            throw new CustomPreconditionErrorException("Error", e);
        }
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(final String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    public String getForeignTableName() {
        return foreignTableName;
    }

    public void setForeignTableName(final String foreignTableName) {
        this.foreignTableName = foreignTableName;
    }
}