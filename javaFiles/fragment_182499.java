public View getInfoContents(Marker arg0) {

    View v = getLayoutInflater().inflate(R.layout.custom_infowindow, null);
    TextView tv = (TextView) v.findViewById(R.id.infoText);
    tv.setText(String.valueOf(CO2data));

    return v;

}