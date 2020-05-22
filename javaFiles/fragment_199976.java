StringBuilder s = new StringBuilder();
try {
    File file = new File(...);
    FileInputStream file_input = new FileInputStream(file);
    DataInputStream data_in = new DataInputStream(file_input );
    while (true) {
        try {
            for (int index = 0; index < 4; index++) {
                byteArray[index] = data_in.readByte();
            }         
        } catch (EOFException eof) {
            break;
        }
        float f = readFloatLittleEndian(byteArray); // transforms 4 bytes into a float
        s.append(f); 
    }
    data_in.close();
} catch (IOException e) {
    System.err.println(e.toString());
}
System.out.print(s);