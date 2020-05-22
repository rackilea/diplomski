DataInputStream stream = new DataInputStream(client.getInputStream());

for (...) {
    int size = stream.readInt();

    try (InputStream imageData = new SubStream(stream, size)) {
        return ImageIO.read(imageData);
    }
    // Note: imageData implicitly closed using try-with-resources
}