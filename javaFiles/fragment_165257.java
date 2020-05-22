@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);

    // get the item that the user clicked
    Plant plant = (Plant) getListAdapter().getItem(position);
    Intent intent = new Intent();
    // EveryThing went fine
    intent.putExtra(PLANT_RESULT, plant);
    setResult(RESULT_OK, intent);
    // Finish this Intent
    finish();
}