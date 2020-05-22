public class FooActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle icicle) {

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
        case R.id.button1:
            // Button 1 was clicked
            break;

        case R.id.button2:
            // Button 2 was clicked
            break;
        }
    }
}