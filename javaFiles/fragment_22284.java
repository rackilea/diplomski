Btssnoop b = Btssnoop.fromFile("/path/to/file.bin");
try {
    b._read();
} catch (IOException e) {
    System.out.println("warning: truncated packets");
}
System.out.println(b.packets.size());