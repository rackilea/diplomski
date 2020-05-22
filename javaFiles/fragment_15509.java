private byte[] readFile(String path) throws IOException {

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    File file = new File(path);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()){
        out.writeUTF(scanner.nextLine() + System.getProperty("line.separator"));
    }

    byte[] bytes = out.toByteArray();
    out.flush();
    return bytes;
}