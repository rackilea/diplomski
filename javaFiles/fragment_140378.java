public class SpinnerActivity extends Activity implements 

OnItemSelectedListener {
    @Override
    protected void onStart() {
         Spinner spinner = (Spinner) findViewById(R.id.spinner);
         spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}