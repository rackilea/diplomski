File file = new File("D://test.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);
    String test = "Address Pippo p.2 °";
    ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(test);
    test = StandardCharsets.UTF_8.decode(byteBuffer).toString();
    pw.write(test);
    pw.close();