File myFile = new File(input);
FileInputStream fIn = new FileInputStream(myFile);
//needed to shrink the copied array in the last iteration of the length of the content
int byteLength;
//find a good buffer size here.
byte[] buffer = new byte[1024 * 128];
ByteArrayOutputStream out = new ByteArrayOutputStream();
while((byteLength = fIn.read(buffer)) != -1){
    byte[] copy = Arrays.copyOf(buffer, byteLength);
    out.write(copy, 0, copy.length);
}
String output = out.toString();