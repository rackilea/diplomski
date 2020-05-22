public class MainActivity extends Activity {

private int specificIndex;
private int generalIndex;
private OnItemSelectedListener optionListener = getOptionListener();
// private OnItemSelectedListener specificListener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((Spinner)findViewById(R.id.optionsSpinner)).setOnItemSelectedListener(optionListener);
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    // Initial setup
    generalIndex = prefs.getInt("general", 0);
    specificIndex = prefs.getInt("specific", 0);
}

@Override
public void onPause()
{
    super.onPause();
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    generalIndex = ((Spinner)findViewById(R.id.optionsSpinner)).getSelectedItemPosition();
    specificIndex = ((Spinner)findViewById(R.id.specificOptions)).getSelectedItemPosition();

    prefs.edit().putInt("general", generalIndex).putInt("specific", specificIndex).commit();
}

@Override
public void onResume()
{
    super.onResume();
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    generalIndex = prefs.getInt("general", 0);
    specificIndex = prefs.getInt("specific", 0);
}

private OnItemSelectedListener getOptionListener()
{
    return new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {

            int resId;
            String selectedOption = parent.getSelectedItem().toString();
            if (selectedOption.equals(getString(R.string.color)))
                resId = R.array.colorsArray;
            else
                resId = R.array.shapesArray;

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getBaseContext(), resId, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ((Spinner)findViewById(R.id.specificOptions)).setAdapter(adapter);

            if (specificIndex != 0)
                ((Spinner)findViewById(R.id.specificOptions)).setSelection(specificIndex);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) { }
    };
}