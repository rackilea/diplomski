File folderFile = getApplicationContext.getDir("folder_file", Context.MODE_PRIVATE);
File fileBeingAdded = new File(folderFile.getPath(), fileBeingAddedTitle);
try{
    folderFile.createNewFile();
    fileBeingAdded.createNewFile();
} catch (IOException e){
    e.printStackTrace();
}