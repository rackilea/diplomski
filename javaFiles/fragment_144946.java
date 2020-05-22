lv.setOnItemClickListener(n## Heading ##ew OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        // When clicked, show a toast with the TextView text
        if(position == 1) {
            //code specific to first list item    
            Intent myIntent = new Intent(view.getContext(), Html_file1.class);
            startActivityForResult(myIntent, 0);
        }

        if(position == 2) {
            //code specific to 2nd list item    
            Intent myIntent = new Intent(view.getContext(), Html_file2.class);
            startActivityForResult(myIntent, 0);
        }
    }
});