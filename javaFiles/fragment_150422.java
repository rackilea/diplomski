public class Example extends Activity {
    EditText[] arrayOfEditText = new EditText[11];
    EditText[] arrayOfEditText1 = new EditText[11];
    ...

        @Override
        public void onCreate(Bundle savedInstanceState) 
        {
            ...  
            arrayOfEditText[1] = (EditText) findViewById(R.id.EditText01);
            etc, etc...