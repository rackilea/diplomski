public class MainActivity extends AppCompatActivity implements FragAHandler,FragBHandler
{

LinearLayout layRoot;
FragmentManager manager=getSupportFragmentManager();
public static final String FRAG_A_TAG = "FRAG_A";
public static final String FRAG_B_TAG = "FRAG_B";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    layRoot = findViewById(R.id.layout_root);
    manager.beginTransaction().add(R.id.layout_root, new Frag_a(), FRAG_A_TAG).commit();
}

@Override
public void addFrag1() {
    if (manager.findFragmentByTag(FRAG_A_TAG) == null) {
        manager.beginTransaction().add(R.id.layout_root, new Frag_a(), FRAG_A_TAG).commit();
    } else {
        Toast.makeText(MainActivity.this, "frag1 Already present", Toast.LENGTH_SHORT);
    }
}

@Override
public void closeFrag1() {
    Frag_a fragA = (Frag_a) manager.findFragmentByTag(FRAG_A_TAG);
    if (fragA != null) {
        manager.beginTransaction().remove(fragA).commit();
    } else {
        Toast.makeText(MainActivity.this, "frag1 Already not there", Toast.LENGTH_SHORT);
    }

}

@Override
public void addFrag2() {

    if (manager.findFragmentByTag(FRAG_B_TAG) == null) {
        manager.beginTransaction().add(R.id.layout_root, new Frag_b(), FRAG_B_TAG).commit();
    } else {
        Toast.makeText(MainActivity.this, "frag2 Already present", Toast.LENGTH_SHORT);
    }
}

@Override
public void closeFrag2() {
    Frag_b frag_b = (Frag_b) manager.findFragmentByTag(FRAG_B_TAG);

    if (frag_b != null) {
        manager.beginTransaction().remove(frag_b).commit();
    } else {
        Toast.makeText(MainActivity.this, "frag2 Already not there", Toast.LENGTH_SHORT);

    }

}
}