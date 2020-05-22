@Dao
public interface WrapperDao {

    @Query( "SELECT *  FROM FirstEntity" )
    public List<Wrapper> getAllWrappers();

}