protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    // Get the item that was clicked

    Intent selectedProjectType = new Intent();

    Cursor o = (Cursor) this.getListAdapter().getItem(position);
    String keyword = o.getString(1);

    selectedProjectType.putExtra("selectedprojecttype", keyword);

    setResult(RESULT_OK, selectedProjectType);
    finish();
}