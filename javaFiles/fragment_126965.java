public class MainActivity extends Activity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void fragmentInterfaceMethod(int your_value) {
        //use your_value to send it to another fragment
    }

}