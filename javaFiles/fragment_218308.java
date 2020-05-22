@Dao
abstract class BaseDao<T> {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   abstract void insert(T entity);

   @Update
   abstract void update(T entity);

   @Delete
   abstract void delete(T entity);
 }

 @Dao
 public abstract class ReasonDao extends BaseDao<Reason>{

    @Query("SELECT * from Reason")
    abstract public List<Reason> getReasons();

  }