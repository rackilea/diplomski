public ArrayList<File> getfile(File dir) {
    File listFile[] = dir.listFiles();
    if (listFile != null && listFile.length > 0) {
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isDirectory()) {
                fileList.add(listFile[i]);
                getfile(listFile[i]);
            } else {
                if (listFile[i].getName().endsWith(".png")
                    || listFile[i].getName().endsWith(".jpg")
                    || listFile[i].getName().endsWith(".jpeg")
                    || listFile[i].getName().endsWith(".gif")) {
                    fileList.add(listFile[i]);
                }
            }
        }
    }
    return fileList;
}