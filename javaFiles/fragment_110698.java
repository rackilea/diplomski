public class MainActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       Log.v(TAG,"MainActivity");
    }
}



public class BaseActivity extends Activity{

    protected static final String TAG = "TAG";

    @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         Log.v(TAG,"BaseActivity");
    }
}