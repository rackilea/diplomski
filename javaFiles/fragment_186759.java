List<Address> addressList = geoCoder.getFromLocationName(cityName, 1);
Address address = addressList.get(0);
if(address.hasLatitude() && address.hasLongitude()){
    double selectedLat = address.getLatitude();
    double selectedLng = address.getLongitude();
}