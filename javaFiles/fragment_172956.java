public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////

        LinearLayout radioPanel= (LinearLayout) findViewById(R.id.radioPanel);

        for (int i = 0; i < 3; i++) {
            RadioButton radioButton=new RadioButton(this);

            radioButton.setSelected(false);

            radioButton.setLeft(16);
            radioButton.setRight(16);

            radioButton.setText("RadioButton "+ i);

            //Here you add these radioButton to the UI
            radioPanel.addView(radioButton);
        }


        ////

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
}