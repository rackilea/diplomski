// deletes /home/kim/files/somefile.txt
boolean result = new File("somefile.txt").delete();

// deletes /home/kim/files/somefile.txt
File f = new File("somefile.txt");
boolean result = new File(f.getCanonicalPath()).delete();

// deletes /home/kim/files/somefile.txt
String execPath = System.getProperty("user.dir");
File f = new File(execPath+"/somefile.txt");
f.delete();