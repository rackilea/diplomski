public class ProfileActivity extends MenuActivity implements IProfiler {

private ProgressBar mProgressar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
    binding.setUser(new User());
    binding.setViewActions(new ProfileViewModel(this));


    //get the toolbar
    Toolbar tb = (Toolbar)findViewById(R.id.toolbarMain);
    setSupportActionBar(tb);

    //set the Progressbar
    mProgressar = (ProgressBar)findViewById(R.id.progressPostUser);
}

@Override
public void ShowProgressbar() {
    mProgressar.setVisibility(View.VISIBLE);
}

@Override
public void HideProgressbar() {
    mProgressar.setVisibility(View.GONE);
}

@Override
public void MakeToast() {
    Toast.makeText(this, "Some toast", Toast.LENGTH_SHORT);
}
}