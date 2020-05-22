ListView lv = getListView();
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        parkirdalam_Id = (TextView) view.findViewById(R.id.parkirdalam_Id);
        String parkirdalamId = parkirdalam_Id.getText().toString();
        Intent objIndent = new Intent(getApplicationContext(),ParkirDalamDetail.class);
        objIndent.putExtra("parkirdalam_Id", Integer.parseInt( parkirdalamId));
        startActivity(objIndent);
    }
});

// loadListViewFromDatabase()
ParkirDalamRepo repo = new ParkirDalamRepo(this);
ArrayList<HashMap<String, String>> parkirdalamList =  repo.getParkirDalamList();
ListAdapter adapter = new SimpleAdapter( MainParkirDalam.this,parkirdalamList, R.layout.view_parkirdalam_entry, 
      new String[] { "id","Nama_Gedung"}, 
      new int[] {R.id.parkirdalam_Id, R.id.nama_gedung});
setListAdapter(adapter);