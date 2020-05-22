File oldFile = ...;
File newDirectory = ...;
String newName = ...;
File newFile = new File(newDirectory, newName);

oldName.renameTo(newFile);