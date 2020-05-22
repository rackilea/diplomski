public Message getFirstMessageFromArray(JsonReader reader) {
    reader.beginArray();
    return getMessageFromJson(reader);
}

public Message getMessageFromJson(JsonReader reader) {
    return new gson().fromJson(reader, Message.class);
}