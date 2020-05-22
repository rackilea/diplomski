@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
       Button clickedItem =(Button) view.findViewById(R.id.button2); 
       clickedItem.setText("Clicked");
    }