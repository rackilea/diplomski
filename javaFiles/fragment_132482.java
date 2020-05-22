private static Adresa createAddress(String[] metadata) {
    String continent = metadata[0];
    String country = metadata[1];
    String city = "";
    if(metadata.length>2){
        city = metadata[2];
    }
    return new Address(continent, country, city);
}