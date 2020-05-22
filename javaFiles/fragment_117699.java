public class MyActivity extends Activity implements View.OnClickListener {
Button myButton;
Button myButtonTwo;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    myButton = (Button) findViewById(R.id.myButtonId);
    myButtonTwo = (Button) findViewById(R.id.myButtonTwo);

    myButton.setOnClickListener(this);
    myButtonTwo.setOnClickListener(this);
}

@Override
public void onClick(View view) {
    if (view.getId() == myButton.getId()) {
        // do something
    } else if (view.getId() == myButtonTwo.getId()){
        // do something else
    }
}