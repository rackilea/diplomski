boolean getAllEmptyFoldersOfDir(File current){
    if(current.isDirectory()){
        File[] files = current.listFiles();
        if(files.length == 0){ //There is no file in this folder - safe to delete
            System.out.println("Safe to delete - empty folder: " + current.getAbsolutePath());
            return true;
        } else {
            int totalFolderCount = 0;
            int emptyFolderCount = 0;
            for(File f : files){
                if(f.isDirectory()){
                    totalFolderCount++;
                    if(getAllEmptyFoldersOfDir(f)){ //safe to delete
                        emptyFolderCount++;
                    }   
                }

            }
            if(totalFolderCount == files.length && emptyFolderCount == totalFolderCount){ //only if all folders are safe to delete then this folder is also safe to delete
                System.out.println("Safe to delete - all subfolders are empty: " + current.getAbsolutePath());
                return true;
            }
        }
    }
    return false;
}