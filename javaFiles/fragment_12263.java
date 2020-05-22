public class MainActivity extends AppCompatActivity {

    @Inject
    Foo foo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerTestComponent.builder().build().inject(this);
    }
}