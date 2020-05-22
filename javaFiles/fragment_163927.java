@Repository
public interface UserClientsRepository extends CrudRepository<UserClients, Long> {

    @Async
    @Query("select userCli from UserClients userCli join userCli.user user join userCli.client client "+ 
           "where user.userName= :userName and client.clientCode= :clientCode")
    Future<UserClients> fetchRecordByUserNameClient(String userName,String clientCode);

}