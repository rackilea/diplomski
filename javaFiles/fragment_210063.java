@Path(IAccountsInstanceApi.PATH)
public interface IAccountsInstanceApi extends IV1Api {
   String PATH = "/Accounts/{AccountId}";
}

@Path(IUsersListApi.PATH)
public interface IUsersListApi extends IAccountsInstanceApi {
   String PATH = IAccountsInstanceApi.PATH + "/Users";

    @GET
    Json listUsers();

    @POST
    Json createUser();
}