String path = "C:\\test\\text.txt";
File f = new File(path);
f.getParentFile().mkdirs(); 
try {
    f.createNewFile();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}