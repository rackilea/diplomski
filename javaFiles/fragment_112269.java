class AddressRetrievalExcepion extends Exception {
    ...
}
public static Address getFromLocation() throws AddressRetrievalExcepion {
    ...
    if (errorCondition) {
        throw new AddressRetrievalExcepion("Cannot get address");
    }
    ...
}

try {
    Address addr = getFromLocation(error);
} catch (AddressRetrievalExcepion ae) {
    System.out.println(ae.getMessage());
}