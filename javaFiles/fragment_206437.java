public class MockitoTest {

    @Test
    public void test() {
        final Activity activityMock = Mockito.mock(TestActivity.class);

        doAnswer(new Answer() {
             @Override
             public Object answer(final InvocationOnMock invocationOnMock) throws Throwable {
                 final Object[] args = invocationOnMock.getArguments();
                 System.out.println("Is argument a Runnable? " + (args[0] instanceof Runnable));
                 System.out.println("What is the argument toString()? " + args[0].toString());
                 return invocationOnMock;
             }
        }).when(activityMock).runOnUiThread(any(Runnable.class));

        runDialogOnUIThread(activityMock);
    }


    public void runDialogOnUIThread(final Activity activity) {
        final Runnable r = new Runnable() {
            @Override public void run() {
                System.out.println("***");
            }};
        activity.runOnUiThread(r);
    }

    public static interface Activity {
        void runOnUiThread(Runnable r);
    }

    public static class TestActivity implements Activity {
        @Override
        public void runOnUiThread(final Runnable r) { r.run(); }
    }

}