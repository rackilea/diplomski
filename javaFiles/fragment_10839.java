public static void loadFiles() {
    for(int x = 0; x < nameOffiles.length; x++){
        MyFile myFile = new MyFile();
        myFile.setName(nameOffiles[x]);
        myFile.setSize(sizeOffiles[x]);

        filecache[x] = myFile;
    }
}