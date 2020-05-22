public static void downloadDocumentByID(String serverUrl, String username, String password ,String documentID,String fileName,String destinationFolder){
       String    fullPath= destinationFolder + fileName;
       Document newDocument =  (Document) getSession(serverUrl, username,  password).getObject(documentID);
       System.out.println(newDocument.getId());
       try {
        ContentStream cs = newDocument.getContentStream(null);
            BufferedInputStream in =new BufferedInputStream(cs.getStream());
                    FileOutputStream fos = new FileOutputStream(fullPath);
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