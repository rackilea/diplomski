ContactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

      ThreeStrings threeStrings = (ThreeStrings)ContactsListView.getItemAtPosition(position);

        Log.i("Item", "Selected: " + threeStrings.getCentre());       
    }
});