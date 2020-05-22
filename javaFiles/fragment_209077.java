void printit(List<Integer> prnt, File outputFile) throws IOException
{
    byte[] outputBytes = new byte[prnt.size()]; int i = 0;
    for (Integer element : prnt) outputBytes[i++] = (byte)element;

    FileOutputStream outputStream =new FileOutputStream(outputFile);
    outputStream.write(b);
    outputStream.close();
    // or replace the previous three lines by one
    java.nio.file.Files.write (outputFile.toPath(), outputBytes);
}

void getfyle(File inputFile) throws IOException
{
    FileInputStream inputStream = new FileInputStream(inputFile);
    byte[] inputBytes = new byte[(int)inputFile.length()];
    inputStream.read(inputBytes);
    inputStream.close();
    // or replace those four lines with
    byte[] inputBytes = java.nio.file.Files.readAllBytes (inputFile.toPath());

    for (byte b: inputBytes) System.out.println (b&0xFF);
    // or if you really wanted a list not just a printout
    ArrayList<Integer> list = new ArrayList<Integer>(inputBytes.length);
    for (byte b: inputBytes) list.add (b&0xFF);
    // return list or store it or whatever
}