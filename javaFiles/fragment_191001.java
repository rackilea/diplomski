String pathOLD = "C:\\test\\old.txt";
String pathNEW = "C:\\test\\new.txt";
File fileOLD = new File(pathOLD);
File fileNEW = new File (pathNEW);
fileOLD.delete();
fileNEW.renameTo(fileOLD);