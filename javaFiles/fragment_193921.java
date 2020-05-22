DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = documentBuilder.parse(file);

NodeList accountDetailsNodes = document.getElementsByTagName("AccountDetails");
for (int i = 0; i < accountDetailsNodes.getLength(); i++) {
    Element accountDetailsElem = (Element) accountDetailsNodes.item(i);
    String accountnumber = accountDetailsElem.getElementsByTagName("Accountnumber").item(0).getTextContent();
    System.out.println("Account #" + (i + 1) + ":");
    System.out.println("  Account number: " + accountnumber);

    NodeList personalDetailsNodes = accountDetailsElem.getElementsByTagName("PersonalDetails");
    for (int j = 0; j < personalDetailsNodes.getLength(); j++) {
        Element personalDetailsElem = (Element) personalDetailsNodes.item(j);
        String age    = personalDetailsElem.getElementsByTagName("age").item(0).getTextContent();
        String name   = personalDetailsElem.getElementsByTagName("name").item(0).getTextContent();
        String gender = personalDetailsElem.getElementsByTagName("gender").item(0).getTextContent();
        String role   = personalDetailsElem.getElementsByTagName("role").item(0).getTextContent();
        System.out.println("  Person #" + (j + 1) + ":");
        System.out.println("    Age: " + age);
        System.out.println("    Name: " + name);
        System.out.println("    Gender: " + gender);
        System.out.println("    Role: " + role);
    }
}