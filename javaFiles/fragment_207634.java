class PersonDeserializer extends JsonDeserializer<Person> {

    @Override
    public Person deserialize(final JsonParser parser,
            final DeserializationContext content) throws IOException,
            JsonProcessingException {

        final ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);

        final Person person = new Person();
        final Iterator<String> fieldNameIter = node.getFieldNames();
        while (fieldNameIter.hasNext()) {
            final String fieldName = fieldNameIter.next();
            if (fieldName.equalsIgnoreCase("EMAIL")) {
                person.setEmail(node.get(fieldName).getTextValue());
            } else if (fieldName.equalsIgnoreCase("NOM")) {
                person.setFirstName(node.get(fieldName).getTextValue());
            } else if (fieldName.equalsIgnoreCase("PRENOM")) {
                person.setLastName(node.get(fieldName).getTextValue());
            } else if (fieldName.equalsIgnoreCase("VILLE")) {
                person.setTown(node.get(fieldName).getTextValue());
            } else if (fieldName.startsWith("LIKE")) {
                person.addLike(Liking.LikingType.LIKE, node.get(fieldName)
                        .getTextValue());
            } else if (fieldName.startsWith("HATE")) {
                person.addLike(Liking.LikingType.HATE, node.get(fieldName)
                        .getTextValue());
            }
        }

        return person;
    }
}