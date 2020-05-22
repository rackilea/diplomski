int c = reader.read();
if (c != -1) {
    System.out.println((char) c);
}
else {
    System.out.println("end of the stream");
}