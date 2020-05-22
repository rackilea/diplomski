@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    Toast.makeText(AdvancedListViewActivity.this, "working", Toast.LENGTH_SHORT).show();
    System.out.println("working!!!!!!!!!");
}