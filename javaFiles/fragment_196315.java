MetricHolder.Builder builder = new MetricHolder.Builder();
MetricHolder first = builder.build();
assertEquals("false", first.clientPayload.get("is_clientid"));
assertEquals("true", first.clientPayload.get("is_deviceid"));

builder.setClientId("").build();
// Hmm, first has changed.
assertEquals("true", first.clientPayload.get("is_clientid"));
assertEquals("false", first.clientPayload.get("is_deviceid"));