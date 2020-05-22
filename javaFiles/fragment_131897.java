public class poisInfoWindowAdapter implements InfoWindowAdapter {

  @Override
  public View getInfoWindow(Marker arg) {
  return null;
}
@Override
public View getInfoContents(Marker marker) {

//Get Layout of POI's popups and assign values to text views.
View InfoPopupLayout = getLayoutInflater().inflate(R.layout.infopopup, null);

TextView t = (TextView)InfoPopupLayout.findViewById(R.id.title);
t.setText(marker.getTitle());

TextView t2 = (TextView)InfoPopupLayout.findViewById(R.id.title2);
t2.setText(marker.getSnippet());

    return InfoPopupLayout;
  }
 }