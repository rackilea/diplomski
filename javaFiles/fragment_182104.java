String absolutePath = new File(".").getAbsolutePath();
System.out.println(absolutePath);// Shows you the path of your Project Folder
int last = absolutePath.length()-1;
absolutePath = absolutePath.substring(0, last);//Remove the dot at the end of path
System.out.println(absolutePath);
String filePath =  "MyFolderInsideEclipseProject\\file.txt";//You know this
System.out.println(absolutePath + filePath);//Get the full path.