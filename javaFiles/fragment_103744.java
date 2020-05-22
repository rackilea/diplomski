public interface DataService{
  @GET("/{user}/data")
  List<Data> listData(@Path("user") String user);
}

RestAdapter restAdapter = new RestAdapter.Builder()
.setEndpoint("https://your.url.com")
.build();

DataService service = restAdapter.create(DataService.class);    

List<Data> datas = service.listData("your_parameter");