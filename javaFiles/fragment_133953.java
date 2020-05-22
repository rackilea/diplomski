listViewDosen.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener() {
  public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
     Data data = dosenList.get(position);
     showUpdateDialog(data.getId(),data.getNama());
     return false;
  }
});