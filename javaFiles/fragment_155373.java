public class MainActivity extends Activity { // changed extended activity
TextView disp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_main);//changed layout name
    disp=(TextView)findViewById(R.id.textView1);
    disp.setText("0");
   }
}