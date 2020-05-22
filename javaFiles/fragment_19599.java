public class MainActivity extends Activity {

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.chat_intera);

        Connection connection = Connection.getInstance (getApplicationContext ());
    }

    // ....
}