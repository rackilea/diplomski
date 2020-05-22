listViewDosen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Data data = dosenList.get(position);
       showUpdateDialog(data.getId(),data.getNama());
   } 
});