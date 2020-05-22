UUID uuid = UUID.randomUUID();
byte[] uuidBytes = new byte[16];
ByteBuffer.wrap(uuidBytes)
        .order(ByteOrder.BIG_ENDIAN)
        .putLong(uuid.getMostSignificantBits())
        .putLong(uuid.getLeastSignificantBits());

con.createQuery("INSERT INTO TestTable(ID, Name) VALUES(:id, :name)")
    .addParameter("id", uuidBytes)
    .addParameter("name", "test1").executeUpdate();