public class CustomNamingStrategy extends EJB3NamingStrategy {

    private static final long serialVersionUID = -1953826881322136108L;
    private String currentTableName;

    public String propertyToColumnName(String propertyName) {

        if (propertyName.equalsIgnoreCase("id")) {
            return currentTableName + "_id";
        } else {
            return StringHelper.unqualify(propertyName);
        }
    }

    public String tableName(String tableName) {
        currentTableName = tableName;
        return tableName;
    }
}