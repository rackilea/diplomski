protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    Object selectedValue = this.getListAdapter().getItem(position);
    String value = selectedValue.toString();
    Toast.makeText(this, "You have chosen  " + value , Toast.LENGTH_LONG).show();


}