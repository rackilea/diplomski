eventBus.send("Vb UUID", "Message for Vb, also containing WebSocket UUID", ar -> {
  if (ar.succeeded()) {
    // All went well
  }
  else {
    // Vb died or has other problems. Your choice how to handle this
  }
});