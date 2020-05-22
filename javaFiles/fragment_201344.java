receive("citrusServiceSyncEndpoint")
    .messageType(MessageType.PLAINTEXT)
    .payload("Req");
send("citrusServiceSyncEndpoint")
    .messageType(MessageType.PLAINTEXT)
    .payload("Rsp");