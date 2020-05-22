public class MainActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {
TextView mChangeDateField;
@Override

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mChangeDateField = findViewById(R.id.changeDateField);

}

public void setDateText(View view){
    ClientChooseDateFragment newFragment =
            new ClientChooseDateFragment();
    newFragment.show(getSupportFragmentManager(),
            "datePicker");

}

@Override
public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
    mChangeDateField.setText("-- " + year + "--- Month" +month);
}


public static class  ClientChooseDateFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Activity needs to implement this interface
        DatePickerDialog.OnDateSetListener listener = (DatePickerDialog.OnDateSetListener) getActivity();
        DatePickerDialog q = new DatePickerDialog(getActivity(), listener, year, month, day);

        return q;
    }
}}