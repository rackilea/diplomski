public long getMessageSize(Message message) {
    CountingOutputStream counter = new CountingOutputStream(new NullOutputStream());
    message.saveChanges();
    message.writeTo(counter);
    return counter.getByteCount();
}