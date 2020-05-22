// check the format and add with the correct field type
if (isValidEmail(altName)) {
    altNames.add(new GeneralName(GeneralName.rfc822Name, "user@mail.com"));
} else if (isValidDnsName(altName)) {
    altNames.add(new GeneralName(GeneralName.dNSName, "test.com"));
} else if (isValidIpAddress(altName)) {
    altNames.add(new GeneralName(GeneralName.iPAddress, "127.0.0.1"));
}
// ... and so on, for all GeneralName types