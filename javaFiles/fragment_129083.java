if (header != null) {
  Set<String> headerEvents = header.getCell().getConsumedEvents();
  if (headerEvents != null) {
    consumedEvents.addAll(headerEvents);
  }
}
...
CellBasedWidgetImpl.get().sinkEvents(this, consumedEvents);