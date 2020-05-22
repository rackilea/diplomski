@Test
  public void dupSortKeyRange() {

    final Dbi<ByteBuffer> db = env.openDbi(DB_1, MDB_CREATE, MDB_DUPSORT);

    try (Txn<ByteBuffer> txn = env.txnWrite()) {
      db.put(txn, bb(5), bb(6));
      db.put(txn, bb(5), bb(7));
      db.put(txn, bb(5), bb(8));
      db.put(txn, bb(6), bb(9));
      txn.commit();
    }

    try (Txn<ByteBuffer> txn = env.txnRead()) {
      ByteBuffer key = bb(5);

      List<Integer> keyValues = new ArrayList<>();
      CursorIterator<ByteBuffer> cursor = db.iterate(txn, KeyRange.closed(key, key));
      for (CursorIterator.KeyVal<ByteBuffer> kv : cursor.iterable()) {
        ByteBuffer value = kv.val().get(new byte[kv.val().remaining()]);
        keyValues.add(value.getInt(0));
      }

      assertEquals(3, keyValues.size(), 0);
      assertTrue(keyValues.containsAll(Arrays.asList(6, 7, 8)));
    }
  }