Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(lat, lng, 1);
                if(addresses.size()>0)
                {
                String cityName = addresses.get(0).getAddressLine(0);
                 String stateName = addresses.get(0).getAddressLine(1);
                 //Toast.makeText(getApplicationContext(),stateName , 1).show();
                 String countryName = addresses.get(0).getAddressLine(2);
                 }
            }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }