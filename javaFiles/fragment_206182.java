@UseStringTemplate3StatementLocator
public interface ThingDAO {
   @SqlQuery("SELECT * FROM things <where>")
   List<Thing> findThingsWhere(@Define("where") String where, 
                               @BindWhereClause() WhereClause whereClause);
}