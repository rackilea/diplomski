public void updateUserAddress() {

    User user = repository.findById(1L);
    List<Address> addresses = user.getAddresses();

    Address address = addresses.get(0); //the address to be removed
    user.removeAddress(address); 

    user.setAddresses(addresses);

    repository.save(user);

}