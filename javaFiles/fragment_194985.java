createFile("C:\\testingfolder","test.csv");

function createFile(folder,file)
{

destinationDir = new java.io.File(folder).mkdirs();
file = new java.io.File(folder,file);
file.createNewFile();
}