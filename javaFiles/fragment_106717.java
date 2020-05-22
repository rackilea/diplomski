Address addr = new Address();
addr.setStreet("Home Street");
addr.setCity("Home City");
addr.setState("Home State Abbr");
addr.setPincode("Home PinCode");
user.setHomeAddress(addr);

addr = new Address(); // make a new address
addr.setStreet("Office Street");
addr.setCity("Office City");
addr.setState("Office State");
addr.setPincode("Office PinCode");
user.setOfficeAddress(addr);