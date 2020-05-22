// Use a Scanner to read the File
Scanner readFile = new Scanner(file);

// Loop Through Each Line
while(readFile.hasNext()) {

    // Get Number as a Byte
    byte[] number = readFile.nextLine().getBytes();

    // Write number to OuputStream
    out.write(number);

    // Flush OuputStream, Never forget to Flush your OutputStreams
    out.flush();

}