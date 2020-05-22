Establishment e = (Establishment) getItem(position);
if (e != null) {
    holder.Name.setText(e.getName());
    holder.Description.setText(e.getDescription());

    Location location = e.getLocation();
    double longitude = location.getLongitude();
    double latitude = location.getLatitude()
    holder.Distance.setText(longitude + "/" + latitude);
}