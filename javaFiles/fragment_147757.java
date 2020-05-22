public String getAddress(double lats, double lons) {

                Geocoder geocoder;
                double lat = lats;
                double lon = lons;
                geocoder = new Geocoder(YourActivityName.this, Locale.getDefault());
                List<android.location.Address> addresses = null;
                try {
                    addresses = geocoder.getFromLocation(lat, lon, 1);
                } catch (IOException e) {

                    e.printStackTrace();
                }

                if (addresses != null) {

                    String address = addresses.get(0).getAddressLine(0); 
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); 

                    return address;
                } else {
                    return "failed";
                }


            }