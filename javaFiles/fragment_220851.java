for(GeocodingResult r : results){
    for (AddressComponent ac : r.addressComponents) { 
        for (AddressComponentType acType : ac.types) {
            if (acType == AddressComponentType.LOCALITY) { 
                System.out.println(ac.longName);
            } else if (acType == AddressComponentType.STREET_ADDRESS) {
               System.out.println(ac.longName); 
            } else if (acType == AddressComponentType.COUNTRY) {
               System.out.println(ac.longName); 
            }
        }
    }
}