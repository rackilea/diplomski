// This goes up each time getAddressList is called.
public int addressesRequested;

public List<Address> getAddressList(){
    addressesRequested++;
    return addressList;
}