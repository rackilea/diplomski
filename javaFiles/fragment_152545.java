public void WriteByteToFile(byte[] mybytes, String filename){

try {

FileOutputStream FOS = openFileOutput(filename, MODE_PRIVATE);
FOS.write(mybytes);
FOS.close();


} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}