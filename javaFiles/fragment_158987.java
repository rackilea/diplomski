EventCartridge eventCartridge = new EventCartridge();
context.attachEventCartridge(eventCartridge);
eventCartridge.addReferenceInsertionEventHandler(new ReferenceInsertionEventHandler() {
  public Object referenceInsert(String reference, Object value) {
    return escaper.html(value.toString());
  }
});