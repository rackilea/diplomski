File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.txt");
file.createNewFile();
if(file.exists())
{      
    OutputStream outputStream1 = new FileOutputStream(file);     
    String id="dfg";
    outputStream1.write(id.getBytes());
    outputStream1.close();
}