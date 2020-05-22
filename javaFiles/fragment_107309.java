// Create an RPC request to begin a new transaction.
  BeginTransactionRequest.Builder treq = BeginTransactionRequest.newBuilder();
  // Execute the RPC synchronously.
  BeginTransactionResponse tres = datastore.beginTransaction(treq.build());
  // Get the transaction handle from the response.
  ByteString tx = tres.getTransaction();

  // Create an RPC request to get entities by key.
  LookupRequest.Builder lreq = LookupRequest.newBuilder();
  // Set the entity key with only one `path_element`: no parent.
  Key.Builder key = Key.newBuilder().addPathElement(
      Key.PathElement.newBuilder()
      .setKind("Trivia")
      .setName("hgtg"));
  // Add one key to the lookup request.
  lreq.addKey(key);
  // Set the transaction, so we get a consistent snapshot of the
  // entity at the time the transaction started.
  lreq.getReadOptionsBuilder().setTransaction(tx);
  // Execute the RPC and get the response.
  LookupResponse lresp = datastore.lookup(lreq.build());
  // Create an RPC request to commit the transaction.
  CommitRequest.Builder creq = CommitRequest.newBuilder();
  // Set the transaction to commit.
  creq.setTransaction(tx);
  Entity entity;
  if (lresp.getFoundCount() > 0) {
    entity = lresp.getFound(0).getEntity();
  }