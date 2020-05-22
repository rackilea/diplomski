public boolean onTap(GeoPoint p, MapView mapView){
    if (super.onTap(p, mapView)) 
        return true; 

    locations.add(new OverlayItem(p, "Point 3", "Point 3"));
    populate();
    return false;
}

@Override
protected boolean onTap(int index) {
  OverlayItem item = locations.get(index);
  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
  dialog.setTitle(item.getTitle());
  dialog.setMessage(item.getSnippet());
  dialog.show();
  return true;
}