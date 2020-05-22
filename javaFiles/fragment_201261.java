ObjectMapper objectMapper = new ObjectMapper();
JsonNode jsonNode = objectMapper.readTree(eventString);
String eventType = jsonNode.get("event").asText();

if( eventType.equalsIgnoreCase("conversation_started")) {
    // create ConversationStarted object using something like:
    ConversationStarted conversationStarted = objectMapper.readValue( eventString, ConversationStarted.class );
}