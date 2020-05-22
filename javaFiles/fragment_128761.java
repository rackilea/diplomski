ArrayList<String> names = new ArrayList<String>();
try {
    names = data.getNameDB(this);
} catch (SQLException e) {
    e.printStackTrace();
}



listAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, names);

// set the adapter
list.setAdapter(listAdapter);