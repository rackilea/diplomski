@Override
public boolean onCreateOptionsMenu(Menu menu) {
  MenuInflater inf = new MenuInflater(this);
  inf.inflate(R.menu.menu_xml, menu);
  return true;
}

@Override
public boolean onPrepareOptionsMenu(Menu menu) {
  MenuItem fave = menu.findItem(R.id.favorite);
  MenuItem unfave = menu.findItem(R.id.unfavorite);

  fave.setVisible(!isFave);
  unfave.setVisible(isFave);
  return true;
}