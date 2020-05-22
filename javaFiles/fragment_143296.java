File file = new File(Environment.getExternalStorageDirectory() + "/hello-4.wav");
byte[] bytes = FileUtils.readFileToByteArray(file);

String encoded = Base64.encodeToString(bytes, 0);                                       
Utilities.log("~~~~~~~~ Encoded: ", encoded);

byte[] decoded = Base64.decode(encoded, 0);
Utilities.log("~~~~~~~~ Decoded: ", Arrays.toString(decoded));

try
{
    File file2 = new File(Environment.getExternalStorageDirectory() + "/hello-5.wav");
    FileOutputStream os = new FileOutputStream(file2, true);
    os.write(decoded);
    os.close();
}
catch (Exception e)
{
    e.printStackTrace();
}