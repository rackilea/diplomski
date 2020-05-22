public class MainActivity extends ActionBarActivity {

private RelativeLayout mRelativeLayout;
private TextView mInfoTextView;
Button buttonSetBackgroundRed;
Button buttonSetBackgroundYellow;
Button buttonSetBackgroundGreen;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonSetBackgroundRed =(Button) findViewById(R.id.buttonSetBackgroundRed);
    buttonSetBackgroundYellow =(Button) findViewById(R.id.buttonSetBackgroundYellow);
    buttonSetBackgroundGreen =(Button) findViewById(R.id.buttonSetBackgroundGreen);

    mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    mInfoTextView = (TextView) findViewById(R.id.infoTextView);

    buttonSetBackgroundRed.setOnClickListener(buttonsClickListener);
    buttonSetBackgroundYellow.setOnClickListener(buttonsClickListener);
    buttonSetBackgroundGreen.setOnClickListener(buttonsClickListener);

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}

View.OnClickListener buttonsClickListener = new View.OnClickListener() {
@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.buttonSetBackgroundRed:
            mInfoTextView.setText(R.string.set_background_red);
            mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
            break;
        case R.id.buttonSetBackgroundYellow:
            mInfoTextView.setText(R.string.set_background_yellow);
            mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
            break;
        case R.id.buttonSetBackgroundGreen:
            mInfoTextView.setText(R.string.set_background_green);
            mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            break;
    }
}
};

}