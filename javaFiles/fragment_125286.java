public class YourItemSelectedListener implements OnItemSelectedListener {

public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    String selected = parent.getItemAtPosition(pos).toString();
}

public void onNothingSelected(AdapterView parent) {
    // Do nothing.
}
}