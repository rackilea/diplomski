public Address(String street, String city, String state, String zip) {
    if (street == null || city == null || state == null || 
            zip == null || !zip.matches("\\d+")) {
        throw new IllegalArgumentException("Invalid Address Argument");
    }
    this.street = street.trim();
    this.city = city.trim();
    this.state = state.trim();
    this.zip = zip.trim();
}