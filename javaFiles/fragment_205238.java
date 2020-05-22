@Component(modules = { /* your modules */ }) public interface YourComponent {

  Retrofit getRetrofit();

  OkHttpClient getOkHttpClient();
}