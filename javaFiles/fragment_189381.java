OutputStream bOut = new BufferedOutputStream(new FileOutputStream("saves/p-" + layer + ".gz"));
DeflaterOutputStream defOut = new DeflaterOutputStream(bOut, new Deflater(Deflater.BEST_SPEED));
//buffer.flip();
byte[] bytes = new byte[1024];
while (buffer.hasRemaining()) {
    int len = Math.min(buffer.remaining(), bytes.length);
    buffer.get(bytes, 0, len);
    defOut.write(bytes, 0, len);
}
defOut.close();