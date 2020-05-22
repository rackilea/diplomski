Geocoder geocoder;
List<Address> yourAddresses;
geocoder = new Geocoder(this, Locale.getDefault());
yourAddresses= geocoder.getFromLocation(yourLatitude, yourLongitude, 1);

if (yourAddress.size() > 0)
{
 String yourAddress = yourAddresses.get(0).getAddressLine(0);
 String yourCity = yourAddresses.get(0).getAddressLine(1);
 String yourCountry = yourAddresses.get(0).getAddressLine(2);
}