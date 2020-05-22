public String replaceWithFalseData(String xmlInstance) {
    Pattern personPattern = Pattern.compile("<Person>.*?</Person>", Pattern.DOTALL);
    Matcher personMatcher = personPattern.matcher(xmlInstance);
    StringBuffer xmlBuffer = new StringBuffer();

    while(personMatcher.find()) {
        String personXml = personMatcher.group();

        Pattern idPattern = Pattern.compile("<personID>(.*)</personID>");
        Matcher idMatcher = idPattern.matcher(personXml);
        idMatcher.find();
        String id = idMatcher.group(1);
        Person fakePerson = getFakePerson(id);

        personXml = personXml.replaceFirst("<firstName>.*</firstName>",
                "<firstName>" + fakePerson.getFirstName() + "</firstName>");

        personXml = personXml.replaceFirst("<lastName>.*</lastName>",
                "<lastName>" + fakePerson.getLastName() + "</lastName>");

        personXml = personXml.replaceFirst("<address>.*</address>",
                "<address>" + fakePerson.getAddress() + "</address>");

        personXml = personXml.replaceFirst("<personID>.*</personID>",
                "<personID>" + fakePerson.getPersonID() + "</personID>");

        personMatcher.appendReplacement(xmlBuffer, personXml);
    }

    personMatcher.appendTail(xmlBuffer);
    return xmlBuffer.toString();
}