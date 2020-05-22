File file = new File("test.txt");
file.createNewFile();

if(file.exists())
{
     OutputStream fo = new FileOutputStream(file);              
     fo.write("Hello World");
     fo.close();
     System.out.println("file created: "+file);
     url = upload.upload(file);
}