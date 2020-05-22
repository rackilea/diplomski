public class MainActivity extends FragmentActivity implements BlankFragment.OnFragmentInteractionListener    {

private BlankFragment fragment = null;
private android.support.v4.app.FragmentManager manager = null;
private android.support.v4.app.FragmentTransaction ft;

public void onFragmentInteraction(Uri uri){
        Log.i("Tag", "onFragmentInteraction called");
    }

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (manager == null) manager = getSupportFragmentManager();            

    if(manager.findFragmentById(R.id.fragment_container) == null) {

        //If a fragment is not already loaded into your container, then add one...

        fragment = new BlankFragment();
        ft= manager.beginTransaction();
        ft.add(R.id.fragment_container,fragment).commit();
    }
}