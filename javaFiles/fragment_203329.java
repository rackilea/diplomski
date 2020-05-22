public class InitialActivity extends SherlockFragmentActivity {
private ItensFragment itensfrag;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_inicial);
    FragmentManager fm = getSupportFragmentManager();
    itensfrag= (ItensFragment) fm.findFragmentByTag("itensfrag");
    if (savedInstanceState == null) {
        if (itensfrag== null) {
            itensfrag= new ItensFragment();
          fm.beginTransaction().replace(R.id.simple_fragment, itensfrag, "itensfrag").commit();
        }
    }
}
}