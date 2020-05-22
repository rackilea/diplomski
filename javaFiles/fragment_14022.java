public Address getAdress(String aUserInput) {
    .../...
    if(.../...) {
        for(Address tAddress : tAddressList) {
            .../...
            if(tAddress.getCountryCode().equals("DE")) {

                return tAddress;
            }
        }
     }
    return null;
}