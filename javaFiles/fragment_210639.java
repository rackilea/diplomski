String path = request.getParameter("Data");
PrintWriter writer = response.getWriter();
 try {
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
   if( !isMultipart ) {
       writer.println("File cannot be uploaded !");
   }
   else {
       ServletFileUpload upload = new ServletFileUpload();
       FileItemIterator iter = upload.getItemIterator(request);
       List list = null;
       while(iter.hasNext()) {
           FileItemStream item = iter.next();
           String name  = item.getFieldName();
           String fileName = item.getName();
           InputStream stream = item.openStream();
           if(item.isFormField()) {
               // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
           } else {

            // Get a file service
            FileService fileService = FileServiceFactory.getFileService();

            // Create a new Blob file with mime-type "text/plain"
            AppEngineFile file = fileService.createNewBlobFile(mimeType, filename);

            // Open a channel to write to it
            boolean lock = true;
            FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);

            // copy byte stream from request to channel
            byte[] buffer = new byte[10000];
            int len;
            while ((len = stream.read(buffer)) > 0) {
                writeChannel.write(ByteBuffer.wrap(buffer, 0, len));
            }

            writeChannel.closeFinally();

            // here your data is saved to blobstore
            // you should now save a blobstore key somewhere (=to a datastore)
            // so that you can find it next time
            String blobKey = fileService.getBlobKey(file).getKeyString();

           }
       }
   }