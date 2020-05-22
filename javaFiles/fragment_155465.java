public class MainActivity extends AppCompatActivity implements FragAHandler,FragBHandler {
    LinearLayout layRoot;

    FragmentManager manager=getSupportFragmentManager();

    public static  final String FRAG_A_TAG="FRAG_A";
    public static  final String FRAG_B_TAG="FRAG_B";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layRoot=findViewById(R.id.layout_root);
        manager.beginTransaction().add(R.id.layout_root,new Frag_a(),FRAG_A_TAG).commit();
        manager.beginTransaction().add(R.id.layout_root,new Frag_b(),FRAG_B_TAG).commit();

    }

}