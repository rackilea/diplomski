private static void searchFolderRecursive1(File folder) {
    if (folder != null) {
        if (folder.listFiles() != null) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    if(file.getName().contains(".pdf")){
                        Log.v("ooo", "path__="+file.getName());
                    }
                } else {
                    searchFolderRecursive1(file);
                }
            }
        }
    }
}