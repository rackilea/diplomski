String path = "C:" + File.separator + "hello" + File.separator + "hi.txt";
// Use relative path for Unix systems
File f = new File(path);

f.getParentFile().mkdirs(); 
f.createNewFile();