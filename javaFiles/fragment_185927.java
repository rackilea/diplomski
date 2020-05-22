public class TestAdapter {
       public static SimpleTestService createService() {
           Retrofit retrofit = new Retrofit.Builder()
                   .baseUrl(SimpleTestService .endpoint)
                   .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

           SimpleTestService service = retrofit.create(SimpleTestService.class);
           return service;
       }
    }