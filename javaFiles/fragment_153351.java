public void saveFoodetails(FooDetails fooDetails) {
  Address address = addressRepository.find( fooDetails.getAddress().getId() );
  if ( address != null ) {
    // perhaps you update address with data from fooDetails.getAddress()
    addressRepository.save( address );
    // associate attached address instance with fooDetails now.
    fooDetails.setAddress( address );
  }
  else {
    // save the new incoming address contained in FooDetails
    addressRepository.save( fooDetails.getAddress() );
  }
  // now save/update FooDetails
  fooDetailsRepository.save( fooDetails );        
}