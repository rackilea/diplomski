public HelloItemizedOverlay(Drawable defaultMarker) {
  super(boundCenterBottom(defaultMarker));
}
public HelloItemizedOverlay(Drawable defaultMarker, String ID, String city, String country) {
  super(boundCenterBottom(defaultMarker));
  #do something with the ID, city, country. Possibly store them in instance variables
}