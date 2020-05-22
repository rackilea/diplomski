String str = "aa:bb:cc:dd:ee:ff";
    MACAddressString addrString = new MACAddressString(str);
    try {
         MACAddress addr = addrString.toAddress();
         ...
    } catch(AddressStringException e) {
        //e.getMessage provides validation issue
    }