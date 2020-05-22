public class mainActivity extends Activity implements OnCustomActionListener {
...
     myCustomButtom.setOnCustomActionListener(this);
...
public void onCustomAction(CustomButton button) {
     // do something
}