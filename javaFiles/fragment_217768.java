myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        //this is what happens when an item in the list is clicked
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //the location of the selected item is stored in i
            //use this location to pull the value and store it in a variable

            int selectedNumber = (Integer) adapterView.getAdapter().getItem(i);

            //you now have the chosen number stored in a variable
        }
    });