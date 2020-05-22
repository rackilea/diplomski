public void walkdir(File dir) {

        File[] listFile;
        listFile = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walkdir(listFile[i]);
                } else {
                  if (listFile[i].getName().toLowerCase().endsWith(".pdf")){
                      files_list.add(listFile[i]);
                  }
                }
            }
        }    
    }