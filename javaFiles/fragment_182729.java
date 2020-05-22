public interface ApiInterface {

    //this could be test1_database/getAllUser.json
    @GET("test1_database/getAllUser.php")
    Call<Result> getWorkers();


}