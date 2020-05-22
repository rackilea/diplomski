if (listOfFiles[i].isFile()) {
        File f = new File(
                "C:\\Users\\N\\Desktop\\New folder\\RenamingFiles\\src\\renaming\\Files\\"// <- Missing separator
                        + listOfFiles[i].getName());
        f.renameTo(new File(
                "C:\\Users\\N\\Desktop\\New folder\\RenamingFiles\\src\\renaming\\Files\\"// <- Missing separator
                        + listOfFiles[i].getName().toUpperCase()
                        + ".txt"));
 }