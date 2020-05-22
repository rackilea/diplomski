Geocoder coder = new Geocoder(this);
List<Address> address;

try {
    address = coder.getFromLocationName(strAddress,5);
    if (address == null) {
        return null;
    }
    Address location = address.get(0);
    location.getLatitude();
    location.getLongitude();


}