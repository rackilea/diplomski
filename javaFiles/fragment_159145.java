File inputFile = new File("InfectiousDisease.xml");
File outFile = new File("tempFile.tmp");

if(inputFile.delete()){
   outFile.renameTo(inputFile);
}