public String calcDonation() {
    if (TextUtils.isEmpty(textAdded)) {
        //textAdded is empty, so just return an empty String
        return "";
    }
    //We're sure that textAdded has a value, so we can try to parse it
    double counter = Double.parseDouble(textAdded);
    addedDonation += counter;

    Locale locale = new Locale("en", "CA");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    return fmt.format(addedDonation);
}