try (PreparedStatement stmt = connection.prepareStatement(
        "INSERT INTO files(blob) VALUES(?)");

    // Either:
    InputStream in = ... uploaded file
    // or:
    byte[] data = ... uploaded file contents
    ByteArrayInputStream in = new ByteArrayInputStream(data);

    stmt.setBinaryStream(1, in);
    stmt.executeUpdate();
}