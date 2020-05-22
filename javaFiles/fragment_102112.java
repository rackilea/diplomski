MappingJsonFactory factory = new MappingJsonFactory();
JsonParser parser = factory.createParser(soc.getInputStream());
JsonToken curToken = parser.nextToken();
if (curToken != JsonToken.START_OBJECT) {
    System.err.println("Not in start object!, Exiting...");
    return null;
}
while (runParser.get() == true) {
    if (curToken == JsonToken.START_OBJECT) {
        TreeNode node = parser.readValueAsTree();
        System.out.println(node.getClass().getName());
        System.out.println(node);
    }
    curToken = parser.nextToken();
}