InternetAddress address = new InternetAddress("testUser@em_company.com", false);

// from API sources:
public InternetAddress(String address, boolean strict) throws AddressException {
   this(address); // THIS CAUSES EXCEPTION ANYWAY
   if (strict) {
      if (isGroup())
         getGroup(true);    // throw away the result
      else
        checkAddress(this.address, true, true);
   }
}