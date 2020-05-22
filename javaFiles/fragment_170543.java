@Dao
public abstract class SessionAndUserDao {   //extends BaseDao<SessionAndUser> { <-- this caused the error

    @Transaction
    @Query("select * from session")
    public abstract LiveData<List<SessionandUser>> getAll();

}