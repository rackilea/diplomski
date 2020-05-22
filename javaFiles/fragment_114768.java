public class MainActivity extends AppCompatActivity {
       Toolbar mToolbar;
       Button mRedColor;
       Button mGreenColor;
       Button mYellowColor;
       Button[] b = new Button[2];
SharedPreferences mSharedPreferences;
SharedPreferences.Editor edit;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_color);
    mSharedPreferences = getSharedPreferences("ButtonColor", MODE_PRIVATE);
    edit = getSharedPreferences("ButtonColor", MODE_PRIVATE).edit();
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    final Button[] b = new Button[]{(Button) findViewById(R.id.btnRed),
            (Button) findViewById(R.id.btnGreen),
            (Button) findViewById(R.id.btnYellow),};

    mToolbar.setTitle(getResources().getString(R.string.app_name));
    int lastPostion = getButtonPosition();
    if (getColor() != getResources().getColor(R.color.colorPrimary)) {
        for (int i = 0; i < b.length; i++) {

            if (b[i].equals(b[0]) && i == lastPostion) {

                b[0].setBackgroundColor(getColor());
                b[i].setEnabled(false);

            } else if (b[i].equals(b[1]) && i == lastPostion) {

                b[1].setBackgroundColor(getColor());
                b[i].setEnabled(false);

            } else if (b[i].equals(b[2]) && i == lastPostion) {

                b[2].setBackgroundColor(getColor());
                b[i].setEnabled(false);


            }

        }
    }

    for (int i = 0; i < b.length; i++) {

        b[i].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId())    //so we get its id here
                {
                    case (R.id.btnRed):
                        b[0].setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                        storeColor(getResources().getColor(android.R.color.holo_red_dark), 0);
                        b[0].setEnabled(false);

                        break;
                    case (R.id.btnGreen):
                        b[1].setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                        storeColor(getResources().getColor(android.R.color.holo_green_dark), 1);
                        b[1].setEnabled(false);
                        break;
                    case (R.id.btnYellow):
                        b[2].setBackgroundColor(getResources().getColor(android.R.color.black));
                        storeColor(getResources().getColor(android.R.color.black), 2);
                        b[2].setEnabled(false);
                        break;
                }
            }
        });
    }
}

@Override
protected void onResume() {
    super.onResume();
    mSharedPreferences = getSharedPreferences("ButtonColor", MODE_PRIVATE);
    edit = getSharedPreferences("ButtonColor", MODE_PRIVATE).edit();
}

@Override
public void onStop() {
    super.onStop();
}

private void storeColor(int color, int position) {
    SharedPreferences mSharedPreferences =
            getSharedPreferences("ButtonColor", MODE_PRIVATE);
    SharedPreferences.Editor mEditor = mSharedPreferences.edit();
    mEditor.putInt("color", color);
    mEditor.putInt("position", position);
    mEditor.apply();
}

private int getColor() {
    SharedPreferences mSharedPreferences =
            getSharedPreferences("ButtonColor", MODE_PRIVATE);
    int selectedColor = mSharedPreferences.getInt("color",
            getResources().getColor(R.color.colorPrimary));
    return selectedColor;
}

private int getButtonPosition() {
    SharedPreferences mSharedPreferences =
            getSharedPreferences("ButtonColor", MODE_PRIVATE);
    int selectedColor = mSharedPreferences.getInt("position", 0);
    return selectedColor;
}