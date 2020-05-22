public abstract class BaseDAO<ENTITY extends BaseEntity> extends NamedParameterJdbcDaoSupport implements IGenericDao<ENTITY> {

    private final String tableName;
    private final Class<ENTITY> entityClass;
    private final List<String> fields;
    private final String insertSQL;
    private final String updateSQL;

    public BaseDAO(Class<ENTITY> entityClass, String tableName, List<String> fields) {
        this.entityClass = entityClass;
        this.tableName = tableName;
        this.fields = fields;

        // init SQLs
        StringBuilder sbInsertSQL = new StringBuilder();
        StringBuilder sbUpdateSQL = new StringBuilder();

        sbInsertSQL.append("INSERT INTO ").append(tableName).append(" (");
        sbUpdateSQL.append("UPDATE ").append(tableName).append(" SET ");

        for (int i = 0; i < fields.size(); i++) {
            if (i > 0) {
                sbInsertSQL.append(", ");
                sbUpdateSQL.append(", ");
            }
            sbInsertSQL.append(fields.get(i));
            sbUpdateSQL.append(fields.get(i)).append("=:").append(fields.get(i));
        }
        sbInsertSQL.append(") ").append("VALUES (");
        for (int i = 0; i < fields.size(); i++) {
            if (i > 0) {
                sbInsertSQL.append(",");
            }
            sbInsertSQL.append(":").append(fields.get(i));
        }

        sbInsertSQL.append(")\n");
        sbUpdateSQL.append(" WHERE id=:id\n");

        this.insertSQL = sbInsertSQL.toString();
        this.updateSQL = sbUpdateSQL.toString();
        Logger.debug("BaseDAO(), insertSQL: [" + insertSQL + "]");
        Logger.debug("BaseDAO(), updateSQL: [" + updateSQL + "]");
    }

    @Override
    public Long save(ENTITY entity) {
        long res;
        if (entity.getId() == null) {
            res = insert(entity);
        } else {
            update(entity);
            res = entity.getId();
        }
        return res;
    }