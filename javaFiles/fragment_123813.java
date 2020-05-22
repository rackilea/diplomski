@Before
public void setUp(){
    ...
    EditProfileActivity activity = activityTestRule.launchActivity(intent);
    activity.setUserPreference(mockedUserPreference);
}