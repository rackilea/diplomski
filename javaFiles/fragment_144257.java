FTPFileFilter filter = new FTPFileFilter() {

         @Override
         public boolean accept(FTPFile ftpFile) {
         return ftpFile.isFile();
        }
  };