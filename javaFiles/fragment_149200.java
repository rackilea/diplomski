Matcher phone = Patterns.PHONE.matcher(aboutText); // no space manipulation...
if (phone.find()) {
    return;
}
for (String word : aboutText.split("\\s+")) {
    Matcher ipaddress = Patterns.IP_ADDRESS.matcher(aboutText); // no space manipulation...
    if (ipaddress.find()) {
        return;
    }

    Matcher domain = Patterns.DOMAIN_NAME.matcher(aboutTextClear);
    if(domain.find()) {
        return;
    }
}