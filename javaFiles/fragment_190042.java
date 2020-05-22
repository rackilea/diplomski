offsetRepository.getState(serializeOffsetKey(topicPartition));
    if (offsetState != null && !offsetState.isEmpty()) {
        // The state contains the last read offset so you need to seek from the next one
        long offset = deserializeOffsetValue(offsetState) + 1;
        log.debug("Resuming partition {} from offset {} from state", topicPartition.partition(), offset);
        consumer.seek(topicPartition, offset);
    }