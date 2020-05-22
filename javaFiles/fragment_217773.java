@Accessor
public interface TableAccessor {
    @Query(
        "INSERT INTO tableName " +
        "(id, data)" +
        "VALUES (:beanId, :beanData)")
    public ResultSet insertProblem(@Param("beanId") int beanId, @Param("beanData") Date beanData);