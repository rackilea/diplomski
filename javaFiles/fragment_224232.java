public class ServiceHelper {

private static final String ENDPOINT = "http://test.com";

private static OkHttpClient httpClient = new OkHttpClient();
private static ServiceHelper instance = new ServiceHelper();
private IPlusService service;


private ServiceHelper() {

    Retrofit retrofit = createAdapter().build();
    service = retrofit.create(IPlusService.class);
}

public static ServiceHelper getInstance() {
    return instance;
}

private Retrofit.Builder createAdapter() {

    httpClient.setReadTimeout(60, TimeUnit.SECONDS);
    httpClient.setConnectTimeout(60, TimeUnit.SECONDS);
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClient.interceptors().add(interceptor);

    return new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create());
}

public Call<List<CategoryModel>> getAllCategory() {
    return service.getAllCategory();
}