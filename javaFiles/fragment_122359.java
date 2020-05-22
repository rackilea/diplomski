public void onLocationChanged(Location location) {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  String formatted = sdf.format(new Date(location.getTime()));

  textTime.setText(formatted);
}