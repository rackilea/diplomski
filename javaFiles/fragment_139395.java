gridView.setOnItemClickListener(new OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        if (pos == 2) {
           Intent nextScreen = new Intent(getApplicationContext(), News.class);
           startActivity(nextScreen);   
        }
        else if (pos == 1) {
           Intent nextScreen = new Intent(getApplicationContext(), Open.class);
           startActivity(nextScreen);   
        }
    }
});