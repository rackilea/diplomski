public class MainActivity extends AppCompatActivity {

   RadioGroup radioGroup;
   RadioButton radioButton;
   TextView textView;
   // Declare SharedPreferences as attributes
   private SharedPreferences sharedPref;
   private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        // Retrieve SharedPreferences 
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Your choice: " + radioButton.getText());
            }
        });
    }

   @Override
   protected void onResume() {
       int radioIdChecked = -1;
       radioIdChecked = sharedPref.getInt("myRadioChecked", radioIdChecked);
       if (radioIdChecked == -1) {
           // ERROR, don't check anything
           Log.d("TAG", "error: don't check anything");
       }
       else {
           RadioButton radioButton = radioGroup.findViewById(radioIdChecked);
           if (radioButton != null) {
               radioButton.setChecked(true);
           }
       }
    }

   @Override
   protected void onPause() {
        editor.putInt("myRadioChecked", radioGroup.getCheckedRadioButtonId());
        editor.commit();
   }