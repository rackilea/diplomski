public class TableName {
  public static final String FIELD_ID = "id";
  public static final String FIELD_PROP = "prop";

  @DatabaseField(id = true)
  public Integer id;

  @DatabaseField
  public String prop;
}

QueryBuilder<TableName, Integer> qb = dao.queryBuilder();
qb.where().eq(TableName.FIELD_PROP, "value");