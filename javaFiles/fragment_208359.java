public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Profile profile = Profile.getCurrentProfile();
        System.out.println("Profile Id: " + profile.getId());
        ProfilePictureView profilePictureView = (ProfilePictureView) findViewById(R.id.profile_image);
        if(profilePictureView != null) {
            System.out.println("Not null.");
            System.out.println("Profile Name: " + profile.getFirstName());
            profilePictureView.setProfileId(profile.getId());
        }
        else {
            System.out.println("Null.");
        }
    }
}