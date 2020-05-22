File f = new File("/Path/To/File/or/Directory");
if (f.exists() && f.isDirectory()) {
   ...
}else{
   throw new IllegalArgumentException();
}