public class MainActivity extends AppCompatActivity {
private CallbackManager fbCallback; //define CallbackManager
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
FacebookSdk.sdkInitialize(this.getApplicationContext());
setContentView(R.layout.activity_main);
callbackManager = CallbackManager.Factory.create();