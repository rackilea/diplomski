String pathToScan = ("C:\\Users\\<User Name>\\desktop\\test\\");
    String target_file;
    File folderToScan = new File(pathToScan);
    File myFile = null; // Added this

    File[] listOfFiles = folderToScan.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
            target_file = listOfFiles[i].getName();
            myFile = listOfFiles[i]; // Added this
            if (target_file.startsWith("YYYY")) {
                System.out
                        .println("-----------------------------------------------");
                System.out.println("Match Found: " + target_file);
                // if the target file exists
                if (myFile.exists()) {

                    long lastmod = myFile.lastModified();
                    SimpleDateFormat format = new SimpleDateFormat(
                            "YYYY-MM-DD");
                    String lastmodi = format.format(new Date(lastmod));

                    File newfile = new File(
                            "C:\\Users\\<User Name>\\desktop\\test\\"
                                    + lastmodi + ".csv");

                    // If rename successful, then print success with file
                    // location
                    if (myFile.renameTo(newfile)) {
                        System.out
                                .println("File Name Change Successful, New File Created:"
                                        + newfile.getPath());
                    } else {
                        System.out.println("File Name Change Failed");
                    }
                }
            }
        }
    }