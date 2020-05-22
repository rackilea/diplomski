@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public void store(@RequestParam String mandrill_events) throws IOException {
    JsonNodeFactory factory = JsonNodeFactory.instance;
    ArrayNode eventsNode = factory.arrayNode();
    ObjectNode eventNode = factory.objectNode();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(mandrill_events);
    if (node.isArray()) {
        for (int i = 0; i < node.size(); i++) {
            eventsNode.add(node.get(i));
        }
    }
    eventNode.set("mandrill_events", eventsNode);
    try {
        MandrillEventList eventList = mapper.readValue(eventNode.toString(), MandrillEventList.class);
        logger.log(Level.FINE, "Webhook has " + eventList.getMandrillEvents().size() + " events to save");
        this.eventService.storeEvents(eventList);
    } catch (Exception e) {
        e.printStackTrace();
        logger.log(Level.SEVERE, "Unable to setup mandrill event list " + e.getMessage());
        throw new IOException("Unable to setup mandrill event list");
    }
}