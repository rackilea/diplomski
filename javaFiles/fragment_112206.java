@Override
public View getView(int position, View convertView, ViewGroup parent) {
  LinearLayout myView;

  MyPOI item = getItem(position);

  Location poiLocation = item.getLocation;

  int compassHeading = // Calculate heading relative to current heading
  float distance = // Calculate distance to POI


  if (convertView == null) {
    myView = new LinearLayout(getContext());
    String inflater = Context.LAYOUT_INFLATER_SERVICE;
    LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
    vi.inflate(resource, myView, true);
  } else {
    trainView = (LinearLayout) convertView;
  }

  TextView distanceView = (TextView)trainView.findViewById(R.id.distance);
  ImageView compassView = (ImageView)trainView.findViewById(R.id.compass);

  distanceView.setText(String.valueOf(distance);
  compassView.setImageLevel(compassHeading);
}