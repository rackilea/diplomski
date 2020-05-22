Lookup lookup = null;
if (databaseFolder.equals(CustomerFolder)) {
    lookup = new CustomerClass();
} else {
    lookup = new AddressClass();
}
lookup.loadClass(fileToLookup);
//Rest of common code