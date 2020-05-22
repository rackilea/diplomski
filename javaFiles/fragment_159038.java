File file = new File("c:\\cygwin\\cygwin.bat");
if (!file.isDirectory())
   file = file.getParentFile();
if (file.exists()){
    ...
}