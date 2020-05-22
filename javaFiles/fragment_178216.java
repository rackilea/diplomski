public void setBusinessPhone(String newBusinessPhone) {
    long numberTest;//Used to test if the new number contains any non digit characters.

    if (newBusinessPhone.length() != 10) { //test to see if the phone number is 10 characters in length.
        throw new IllegalArgumentException("Phone number must be 10 digits in length.");
    }

    try { //Test if the new phone number contains any non numeric characters.
        numberTest = Long.parseUnsignedLong(newBusinessPhone);
    }
    catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
        System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
    }
    businessPhone = newBusinessPhone;

}