public class ExampleActivity extends Activity {

int pressedButtonNumber;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_poll);
    pressedButtonNumber = getIntent().getExtras().getInt("buttonNumber");
    switch(pressedButtonNumber){
         case 1:
         //Do Something for clicking button 1 scenario
         break;
    }
}