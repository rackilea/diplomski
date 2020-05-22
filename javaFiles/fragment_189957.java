public void onItemSelected(AdapterView<?> parent,
    View view, int pos, long id) {

    if (parent.getItemAtPosition(pos).toString().equals("Add Item")) {
         arrayAdapter.add(new object());  //object is what your array contains
    }
}