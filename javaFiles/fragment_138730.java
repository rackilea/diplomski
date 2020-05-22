public class AbcActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //... your code here, to get button objects from xml file
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                clearEditText(R.id.editText1);
                break;
            case R.id.button2:
                clearEditText(R.id.editText2);
                break;
            case R.id.button3:
                clearEditText(R.id.editText3);
                break;
            case R.id.button4:
                clearEditText(R.id.editText4);
                break;
        }
    }

    private void clearEditText(int editTextId) {
        findViewById(editTextId).setText("");
    }

}