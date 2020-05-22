public static void getList(String dir) {
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println(listOfFiles[i].getAbsolutePath());
                    File[] listOfFiles1 = folder.listFiles();
                    if (listOfFiles1 != null) {
                        for (int j = 0; j < listOfFiles1.length; j++) {
                            ListFilesUtil.getList(listOfFiles1[j].getPath());
                        }
                    }
                }
            }
        }
    }