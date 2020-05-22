public class Sample extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonmale, radioButtonfemale;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stackover);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnDisplay.setEnabled(false);
        radioButtonmale = (RadioButton) findViewById(R.id.radioMale);
        radioButtonfemale = (RadioButton) findViewById(R.id.radioFemale);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(id);
                if (radioButton.getId() == R.id.radioMale) {
                    btnDisplay.setEnabled(true);
                } else {
                    btnDisplay.setEnabled(true);
                }
            }
        });

    }
}