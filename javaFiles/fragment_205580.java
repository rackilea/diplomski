RestAdapter restAdapter=new RestAdapter.Builder()
        .setEndpoint("http://api.flickr.com/services")
        .setLogLevel(RestAdapter.LogLevel.FULL)//log your request
        .build();
 }

public interface ApiInterface {
@GET("/rest")  //
void getPhotos(@Query("method") String method, @Query("api_key") String key, @Query ("user_id") String user, @Query("format") String format, @Query("city") String city, Callback<FlickrResponse> callback);
     }