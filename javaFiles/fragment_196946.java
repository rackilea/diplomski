import okhttp3.ResponseBody;
import retrofit2.Response;

Response<ResponseBody> response = call.execute();
try ( ResponseBody responseBody = response.body() ) {
    InputStream is = responseBody.byteStream();
    // ...
}