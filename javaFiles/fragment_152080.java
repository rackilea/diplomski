public static void main(String[] args) throws IOException {
    try {
        long _start = System.currentTimeMillis();
        ZipFile _zipFile =  new ZipFile(System.nanoTime()+".zip");
        ZipParameters _parameters = new ZipParameters();
        _parameters.setCompressionMethod(Zip4jConstants.COMP_STORE);
        _parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
        _parameters.setIncludeRootFolder(false);
        ArrayList<File> _files = new ArrayList<File>();
        for(int j=1;j<5;j++){
            _files.add(new File("1.jpg"));
        }            
          System.out.println("Initializing files: "+(System.currentTimeMillis() - _start));
        _zipFile.createZipFile(_files, _parameters);
           System.out.println("Initial run: "+(System.currentTimeMillis() - _start));
        for(int i=0;i<10;i++){
            long start = System.currentTimeMillis();
            ZipFile zipFile =  new ZipFile(System.nanoTime()+".zip");
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_STORE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            parameters.setIncludeRootFolder(false);
            ArrayList<File> files = new ArrayList<File>();
            for(int j=1;j<5;j++){
                files.add(new File("1.jpg"));
            }
            zipFile.createZipFile(files, parameters);


            File zippedFile = zipFile.getFile();
            byte[] buffer = new byte[(int)zippedFile.length()];
            FileInputStream fis = new FileInputStream(zippedFile);
            fis.read(buffer);
            fis.close();
            zippedFile.delete();
               System.out.println("Time taken for "+(i+1)+"tenter code hereh run: "+(System.currentTimeMillis() - start));
        }
    } catch (ZipException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
}