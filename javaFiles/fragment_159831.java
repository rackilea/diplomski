Geocoder geoCoder = new Geocoder(getActivity(), Locale.getDefault());
    List<Address> address = null;

    if (geoCoder != null) {
        try {
            address = geoCoder.getFromLocationName("KT48LY", 10);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (address.size() > 0) {
            Address first = address.get(0);
            double lat = first.getLatitude();
            double lon = first.getLongitude();
        }
    }