public class FontSettings extends AppCompatActivity {

    private Spinner spinner1, spinnerLatin;
    private SharedPreferences mMyPrefs;
    private SharedPreferences.Editor mMyEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_font);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Display data size teks arab in dropdown list spinner
        final Spinner spinnerBackgroundChange = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.country_arrays, android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.textview_with_background);
        spinnerBackgroundChange.setAdapter(spinnerArrayAdapter);

        // Code pasted here
        if (spinnerBackgroundChange.getSelectedItemPosition() == 0) {
            int lastSelectedPosition = sharedPref.getInt("spinnerValue", 0);
            spinnerBackgroundChange.setSelection(lastSelectedPosition);
        }

        spinnerBackgroundChange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPref = getSharedPreferences("My_Prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putInt("spinnerValue", spinnerBackgroundChange.getSelectedItemPosition());
                editor.apply();

               // Code removed here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Display data size teks latin in dropdown list spinner
        Spinner spinnerLatin = (Spinner)findViewById(R.id.spinnerLatin);
        ArrayAdapter<CharSequence> spinnerArrayLatin = ArrayAdapter.createFromResource(this, R.array.country_arrays, android.R.layout.simple_spinner_item);
        spinnerArrayLatin.setDropDownViewResource(R.layout.textview_with_background);
        spinnerLatin.setAdapter(spinnerArrayLatin);
        // spinnerLatin default value
        spinnerLatin.setSelection(1);

        addListenerOnSpinnerItemSelection();
        addListenerOnSpinner2ItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SizeArabFont());
    }

    public void addListenerOnSpinner2ItemSelection() {
        spinnerLatin = (Spinner) findViewById(R.id.spinnerLatin);
        spinnerLatin.setOnItemSelectedListener(new SizeLatinFont());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } 
}