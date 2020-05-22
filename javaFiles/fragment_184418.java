public EventEntry executePutUpdateEvent(EventEntry updated) throws IOException {
AtomContent content = new AtomContent();
content.namespaceDictionary = DICTIONARY;
content.entry = updated;
HttpRequest request =
    requestFactory.buildPutRequest(new GenericUrl(updated.getEditLink()), content);
return request.execute().parseAs(updated.getClass());}