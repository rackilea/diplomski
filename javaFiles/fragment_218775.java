@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    Bundle positionBundle = new Bundle();
    positionBundle.putInt("position", position);
    Intent i = new Intent(this, MyOtherActivity.class);
    i.putExtras(positionBundle);
    startActivity(i);
}