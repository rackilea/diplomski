try {
    // phone must begin with '+'
    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    Phonenumber.PhoneNumber numberProto = phoneUtil.parse("+91-9876543210", "");
    int countryCode = numberProto.getCountryCode();
    long nationalNumber = numberProto.getNationalNumber();
    Log.i("code", "code " + countryCode);
    Log.i("code", "national number " + nationalNumber);
} catch (NumberParseException e) {
    System.err.println("NumberParseException was thrown: " + e.toString());
}