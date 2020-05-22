int lastDot = saveFile.getName().lastIndexOf('.');
String name = saveFile.getName();
String ext = ""; // Might not have a file extension
if(lastDot > 0) { // At least one dot
    // Take substring of the last occurrence
    ext = saveFile.getName().substring(lastDot);
    name = name.substring(0, lastDot);
}

saveFile.renameTo(new File(defaultDirectory + "/" + name + "_" + user + ext));