File fileToUpload = new File(name);
fileToUpload.createNewFile();

try {
    FileOutputStream oFile = new FileOutputStream(fileToUpload, false); 
    ...