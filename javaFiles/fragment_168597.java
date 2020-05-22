List<File> fileList = new ArrayList<>();
List<File> dirList = new ArrayList<>();
while (count < allDocs.length){
    if (allDocs[count].isDirectory()){
        dirList.add(allDocs[count]);
        System.out.println("Document " + allDocs[count].getPath() 
            + " sorted into -Directory- array at position " + dirCount);
        dirCount++;
    }
    else{
        fileList.add[allDocs[count]);
        System.out.println("Document " + allDocs[count].getPath()
            + " sorted into -File- array at position " + fileCount);
        fileCount++;
    }
    count++;
}
dirs = dirist.toArray(new File[dirList.size()]);
dirCount = dirs.length;
files = fileList.toArray(new File[fileList.size()]);
fileCount = files.length;