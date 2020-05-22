private String createCustomerJson(String firstname,
  String lastname) {
      String createCustomerJsonStringBuilder = "{\"SERVICE\":\"customer.create\",\"DATA\":{\"CUSTOMER_TYPE\":\"";
    createCustomerJsonStringBuilder += "consumer";
    createCustomerJsonStringBuilder += /* "\", */"\"LAST_NAME\":\"";
    createCustomerJsonStringBuilder += lastname;
    createCustomerJsonStringBuilder += "\",\"FIRST_NAME\":\"";
    createCustomerJsonStringBuilder += firstname;
    createCustomerJsonStringBuilder += "\"}}";

    return createCustomerJsonStringBuilder;
}