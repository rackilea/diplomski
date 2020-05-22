public class TokenSpinner implements android.widget.AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       MainActivity.selectedItemInSpinner=parent.getSelectedItem().toString();
        MainActivity.editText.setText(MainActivity.selectedItemInSpinner);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}