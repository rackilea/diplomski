373       public InputStream getInputStream() throws IOException {
  ...
  390           try {
  391               decodePath(url.getPath());
  392               if (filename == null || type == DIR) {
  ...
  399               } else {
  400                   if (type == ASCII)
  401                       ftp.ascii();
  402                   else
  403                       ftp.binary();
  404                   cd(pathname);
  405                   is = new FtpInputStream(ftp, ftp.get(filename));
  406               }
  407   
  408
  ...
  453           } catch (FileNotFoundException e) {
  454               try {
  455                   cd(fullpath);
  456                   /* if that worked, then make a directory listing
  457                      and build an html stream with all the files in
  458                      the directory */
  459                   ftp.ascii();
  460   
  461                   is = new FtpInputStream(ftp, ftp.list());
  462                   msgh.add("content-type", "text/plain");
  463               } catch (IOException ex) {
  464                   throw new FileNotFoundException(fullpath);
  465               }
  466           }
  ...
  469       }