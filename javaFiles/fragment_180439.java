public class EditTextArray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_array);

        EditText et = (EditText) findViewById(R.id.editText);
        et.setText("1452");  // Normally user input here...

        String text = et.getText().toString();

        int[] array = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            array[i] = Character.getNumericValue(text.charAt(i));
        }

        Log.d("Output: ", Arrays.toString(array));
        //09-20 14:27:45.272 20400-20400/com.jtwaller.test D/Output:: [1, 4, 5, 2]

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(array[i] + " ");
        }

        Log.d("Output: ", sb);
        //09-20 14:27:45.272 20400-20400/com.jtwaller.test D/Output:: 1 4 5 2 
    }
}