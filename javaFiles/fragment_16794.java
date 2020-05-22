File originalFile = ...;
String name = originalFile.getName();
int lastIndexOfDot = name.lastIndexOf('.');
String newFileName = name.substring(0, lastIndexOfDot)
                     + "v2" 
                     + name.substring(lastIndexOfDot);
File newFile = new File(originalFile.getParentFile(), newFileName);