public User(int id, String firstName, int addressId, String state) {
    this.id = id;
    this.firstName = firstName;
    this.address = new Address();
    this.address.setState(state);
    this.address.setId(addressId);