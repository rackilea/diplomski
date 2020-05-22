public class MainActivity extends AppCompatActivity {

Button Btn;
TextView textView;
String cnt = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Btn = (Button) findViewById(R.id.button);
}

public void onBtnClick(View view) {
    textView = (TextView) findViewById(R.id.textView);
    textView.setText("Hehe");
}

protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    textView = (TextView) findViewById(R.id.textView);
    cnt = (String) textView.getText();
    outState.putString("count", cnt);
}

protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    cnt = savedInstanceState.getString("count");
    textView = (TextView) findViewById(R.id.textView);
    textView.setText(cnt);
}
}