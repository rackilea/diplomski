public static String parseFilename(String filename){
 String s = filename.substring(0, filename.lastIndexOf('_') - 1);
 return s;
}

public static void makeDir(String dirname){
 File dir = new File(dirname);
 if(!dir.exists())
  dir.mkdir();
}