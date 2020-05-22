import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Omar on 4/17/2017.
 */

public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.url().encodedPath().equalsIgnoreCase("/oauth/token")
                || (request.url().encodedPath().equalsIgnoreCase("/api/v1/users") && request.method().equalsIgnoreCase("post"))) {
            return  chain.proceed(request);
        }
        Request newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer token-here")
                .build();
        Response response = chain.proceed(newRequest);
        return response;
    }
}