public class MainActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
TextView tv= new TextView(this);
setContentView(tv);
tv.setText("hello");
 }
}