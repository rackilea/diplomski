public static UUID toUUID(byte[] bytes) {
    ByteBuffer idBuffer = ByteBuffer.wrap(bytes);
    return new UUID(idBuffer.getLong(), idBuffer.getLong());
}

    UUID uuid = toUUID(rs.getBytes(1));

public static byte[] fromUUID(UUID uuid) {
    byte[] bytes = new byte[16];
    ByteBuffer idBuffer = ByteBuffer.wrap(bytes);
    idBuffer.putLong(uuid.getMostSignificantBits());
    idBuffer.putLong(uuid.getLeastSignificantBits());
    return bytes;
}

    rs.setBytes(1, fromUUID(uuid));