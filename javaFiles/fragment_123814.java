@Before
public void setUp(){
    ...
    EditProfileActivity activity = activityTestRule.launchActivity(intent);
    Field userPreferenceField = activity.getClass().getDeclaredField("userPreference");
    field.setAccessible(true);
    userPreferenceField.set(activity, mockedUserPreference);
}