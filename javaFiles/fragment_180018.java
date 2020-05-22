@RunWith(RobolectricTestRunner.class)
public class AdventureTest {
    ...
    @Test
    public void adventureWorld() {
        mActivity = Robolectric.buildActivity(FullscreenActivity.class)
                .create()
                .get();

        ag = new AdventureGame(mActivity, null);

        // Simulation myObjecUnderTest = new Simulation();
        final TextView speechTextView = new TextView(mActivity);

        final Adventure adventure = new Adventure(speechTextView, mActivity, ag);

        final Player player = adventure.getPlayer();
        player.say("foobar", mActivity);
        player.say("Hello my name is " + adventure.getPlayer().getMe().name, mActivity);


        assertThat(speechTextView.getText()).containsIgnoringCase("Hello my name is");
    }
    ...