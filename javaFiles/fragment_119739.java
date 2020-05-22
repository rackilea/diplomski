private List<Item> displayData = new ArrayList<Item>();

public void cap_search(){
        EditText search = (EditText) findViewById(R.id.search);
        String str_search = null;

        str_search = search.getText().toString();
        displayData.clear();
        if (str_search == null || str_search.equals("")) {
            displayData.addAll(data);
        } else {
            for (int i = data.size()-1; i >= 0; i--){
                if (data.get(i).getCaption().contains(str_search)){
                    displayData.add(data.get(i));
                }
            }
        }
        adapter = new ItemListAdapter(this, displayData);
        setListAdapter(adapter);
}