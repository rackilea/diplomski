@Singleton
@Component(modules = {CoffeeModule.class, MilkModule.class})
public interface AppComponent {

  void inject(LoginActivity app);

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder appModule(MyMvpApp myMvpApp);

    AppComponent build();
  }
}



public class LoginActivity extends AppCompatActivity {
  @Inject
  Milk milk;

  @Inject
  Coffee coffee;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DaggerAppComponent.builder().appModule((MyMvpApp) getApplicationContext()).build().inject(this);
    Log.i("tag", "" + milk + coffee);
  }
}


public class MyMvpApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    initDagger();
  }

  private void initDagger() {
    AppComponent appComponent = DaggerAppComponent.builder()
        .appModule(this)
        .build();
  }
}