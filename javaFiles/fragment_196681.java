@POST
public String createAddress(AddressLocationRequest requestObj) {

   AddressLocation address = new AddressLocation();
   BeanUtils.copyProperties(address, requestObj);
   ...
}