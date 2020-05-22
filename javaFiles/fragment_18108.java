public class MainActivity extends Activity  implements View.OnClickListener{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.button1).setOnClickListener(this);
    findViewById(R.id.button2).setOnClickListener(this);
    findViewById(R.id.button3).setOnClickListener(this);
    findViewById(R.id.button4).setOnClickListener(this);
    findViewById(R.id.button5).setOnClickListener(this);
    findViewById(R.id.button6).setOnClickListener(this);
    findViewById(R.id.button7).setOnClickListener(this);
    findViewById(R.id.button8).setOnClickListener(this);
    findViewById(R.id.button9).setOnClickListener(this);
}

@Override
public void onClick(View v) {
    Intent intent = null;
    switch (v.getId()) {
        case R.id.button1:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button2:
            Uri uri = Uri.parse("https://www.rkz.nl/nieuws_agenda_nieuws");
            intent = new Intent(Intent.ACTION_VIEW, uri);
            break;
        case R.id.button3:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button4:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button5:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button6:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button7:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button8:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
        case R.id.button9:
            intent = new Intent(MainActivity.this, ActivityB.class);
            break;
    }
    startActivity(intent);
}}