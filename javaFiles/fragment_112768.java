private void fileLister(File directory){
    File[] existingFiles =directory.listFiles();
    for(int i = 0;i<existingFiles.length;i++){

        if(existingFiles[i].isDirectory()){

            fileLister(existinFiles[i]);

        }
        else{

            List<File> templist = Arrays.asList(existingFiles);
                allExsistingFiles.addAll(templist);
        }
    }
}