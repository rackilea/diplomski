public boolean addFiles(String name, List<File> files) {
    String path = "D:\\Server Repository\\UsersFiles\\";
    File folder = new File(path + name);

    if (!folder.exists()) {
        folder.mkdirs();
    }

    try {
        for (File file : files) {
            FileInputStream fisOrigin;
            FileOutputStream fosDestiny;
            //channels  
            FileChannel fcOrigin;
            FileChannel fcDestiny;

            fisOrigin = new FileInputStream(file);
            fosDestiny = new FileOutputStream(new File(folder.getAbsolutePath() + "/" + file.getName()));

            fcOrigin = fisOrigin.getChannel();
            fcDestiny = fosDestiny.getChannel();
            //Copy the file
            fcOrigin.transferTo(0, fcOrigin.size(), fcDestiny);

            fisOrigin.close();
            fosDestiny.close();
        }
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}