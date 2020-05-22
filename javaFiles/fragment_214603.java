public interface UserRequestResponseRepository extends CrudRepository<UserRequestResponse, Integer> {
public static final String FIND_QUERY = 
"select new com.abc.datacollection.entity.UserRequestResponse(user.u_httpstatus ,user.u_queryparam, COUNT(user.u_type)) from UserRequestResponse user GROUP BY user.u_type";
@Query(value = FIND_QUERY)
//public List<UserProjection> getAllRequestResponseRecords();
 List<UserProjection> findAllProjectedBy();