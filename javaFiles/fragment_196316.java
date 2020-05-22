{
  Map<String, String> copyOfClientPayload = new HashMap<>(builder.clientPayload);
  copyOfClientPayload.put("is_clientid", (clientId == null) ? "false" : "true");
  copyOfClientPayload.put("is_deviceid", (clientId == null) ? "true" : "false");
  this.clientPayload = Collections.unmodifiableMap(copyOfClientPayload);
}