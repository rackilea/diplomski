// inside fragment
public void selectionChanged(int position) {
    // update listView
}


// in the activity
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    fragmentA.selectionChanged(position);
    fragmentB.selectionChanged(position);
    fragmentC.selectionChanged(position);
}