public class MainActivity extends Activity implements Handler.Callback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        // Handle your message here
        return false;
    }    
}