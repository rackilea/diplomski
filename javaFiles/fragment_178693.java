DataOutputStream stream = new DataOutputStream(server.getOutputStream());

ByteArrayOutputStream buffer = new ByteArrayOutputStream();
for (...) {
    buffer.reset();
    ImageIO.write(image, "png", buffer);

    stream.writeInt(buffer.size());
    buffer.writeTo(stream); // Send image to server
}