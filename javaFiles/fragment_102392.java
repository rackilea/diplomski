public class MainActivity extends Activity implements MyXextView.MyTextListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    
    }

    @Override
    public void updateUI() {
        //update here
    }

}