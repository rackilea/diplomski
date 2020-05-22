public static void downloadDocumentByPath(String serverUrl, String username, String password ,String path,String destinationFolder){
       String fileExtention = path.substring(path.lastIndexOf(".")+1,path.length());
       String folderPath=path.substring(0,path.lastIndexOf("/"));
       String fileName=path.substring(path.lastIndexOf("/")+1,path.length());
       Folder parentFolder =  getFolderByPath(serverUrl, username,  password,folderPath);
       Document newDocument =  getChild(serverUrl, username,  password , parentFolder ,fileName);
       String fullPath = destinationFolder+fileName;

     try {
        ContentStream cs = newDocument.getContentStream(null);
            BufferedInputStream in =new BufferedInputStream(cs.getStream());
                    FileOutputStream fos = new FileOutputStream(destinationFolder);
                     System.out.println("****-**"+destinationFolder+":::");
                    OutputStream bufferedOutputStream = new BufferedOutputStream(fos);
                    byte[] buf = new byte[1024];
                    int n=0;
                    while ((n=in.read(buf))>0)
                    {
                        bufferedOutputStream.write(buf,0,n);
                    }
        bufferedOutputStream.close();
                    fos.close();
                    in.close();
        }
       catch (IOException e)
       {
        throw new RuntimeException(e.getLocalizedMessage());
       }
     }