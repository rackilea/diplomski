public class MyActivity extends RoboActivity {

    @Inject
    ITest test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // You can now use your test instance
    }

}