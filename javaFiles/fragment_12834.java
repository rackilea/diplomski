@Override
public void onItemSelected(AdapterView parent, View view, int pos, long id) {
    if(pos==0) {
        //do something;
    } else {
        Toast.makeText(parent.getContext(), 
            parent.getItemAtPosition(pos).toString(), 
            Toast.LENGTH_SHORT).show();
    }
}