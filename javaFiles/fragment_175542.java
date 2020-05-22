if (txn != null &&
        bulkAddRequest.encodingSize() > QueueConstants.maxTransactionalRequestSizeBytes()) {
      throw new IllegalArgumentException(
          String.format("Transactional add may not be larger than %d bytes: %d bytes requested.",
              QueueConstants.maxTransactionalRequestSizeBytes(),
              bulkAddRequest.encodingSize()));
    }