class ProcurementEvents {
  private List<ProcurementEvent> _procurementEvent; // + annotations like @JsonIgnoreProperties, getters/ setters, etc.
}

// json from your example
ProcurementEvents events = om.readValue(json, ProcurementEvents.class);
events.get(0).getAccountId();