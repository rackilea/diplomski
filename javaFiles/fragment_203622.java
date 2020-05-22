@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";

    @Rule public ActivityTestRule<TestingActivity> activityTestRule = new ActivityTestRule<>(
        TestingActivity.class, false, false);

    @Before
    public void setUp() throws Exception {
        activityTestRule.launchActivity(new Intent());
    }

    @Test
    public void testAsyncTask() throws Throwable {
        Log.d(TAG, "testAsyncTask entry");

        AsyncTask<String, Void, Integer> task = new AsyncTask<String, Void, Integer>() {

            @Override
            protected Integer doInBackground(String... params) {
                Log.d(TAG, "doInBackground() called with: params = [" + params + "]");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {
                }
                return params.length;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                Log.d(TAG, "onPostExecute() called with: integer = [" + integer + "]");
                assertEquals(3, (int) integer);
                throw new RuntimeException("this should fail the test");
            }
        };
        task.execute("One", "two", "three");
        Espresso.onView(withId(android.R.id.content)).perform(ViewActions.click());

        Log.d(TAG, "testAsyncTask end");
    }
}