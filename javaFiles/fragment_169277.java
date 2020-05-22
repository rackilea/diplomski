public void testPrettyPrint() {
    String compactJson = "{\"playerID\":1234,\"name\":\"Test\",\"itemList\":[{\"itemID\":1,\"name\":\"Axe\",\"atk\":12,\"def\":0},{\"itemID\":2,\"name\":\"Sword\",\"atk\":5,\"def\":5},{\"itemID\":3,\"name\":\"Shield\",\"atk\":0,\"def\":10}]}";

    String prettyJson = toPrettyFormat(compactJson);

    System.out.println("Compact:\n" + compactJson);
    System.out.println("Pretty:\n" + prettyJson);
}