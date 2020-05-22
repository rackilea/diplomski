OutputStream os=null;
    Writer fileWriter = null;
    File f=new File("myfile");

try {
    os =new FileOutputStream(f);
    fileWriter =new OutputStreamWriter(os,"UTF-8");
} finally {
 // close writer, then outputstream if they are not null
}