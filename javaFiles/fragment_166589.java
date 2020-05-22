private void validateAndSend(final Partition partition) {
    final ConcurrentLinkedQueue<DataHolder> dataHolders = dataHoldersByPartition.get(partition);

    // the instance providing sendToDatabase() method
    // just for cutting off details external to the discussion
    final DatabaseDelivery delivery = this;
    final Message message = new Message(partition, this);

    DataHolder dataHolder;
    while ((dataHolder = dataHolders.poll()) != null) {
        // XXX: why is client key using explicit encoding while process bytes is not?
        message.addAndSendJunked(dataHolder.getClientKey().getBytes(StandardCharsets.UTF_8), dataHolder.getProcessBytes());
    }
    message.close();
}