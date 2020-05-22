public class LoginActivity extends Activity implements LoginFragment.OnLoginFragmentInteractionListener {

private FragmentManager fragmentManager;
private FrameLayout frameLayout;
private LoginFragment loginFragment;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    fragmentManager = this.getFragmentManager();
    ViewGroup root = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
    frameLayout = (FrameLayout) root.findViewById(R.id.frameLayout);
    loginFragment = (LoginFragment) fragmentManager.findFragmentByTag("loginFragment");

    if (loginFragment == null) {
        // If fragment wasn't saved, create new one
        Log.d("DEBUG", "Fragment is null");
        loginFragment = new LoginFragment().newInstance("param1", "param2");
    }
    else
        Log.d("DEBUG", "Fragment is not null");

    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(frameLayout.getId(), loginFragment, "loginFragment");
    transaction.commit();
}

@Override
public void onLoginFragmentInteraction(int id) {
    Log.e("DEBuG", "id: "+id);
}