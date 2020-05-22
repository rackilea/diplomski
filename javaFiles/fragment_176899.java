@Override
          public void doPost(HttpServletRequest req, HttpServletResponse res)
              throws ServletException, IOException {

            //Read the file contents from the input stream
            GcsService gcsService = GcsServiceFactory.createGcsService();

            GcsFilename filename = new GcsFilename(BUCKETNAME, FILENAME);          

            GcsFileOptions options = new GcsFileOptions.Builder()
                    .mimeType("image/jpg")
                    .acl("public-read")
                    .addUserMetadata("myfield1", "my field value")
                    .build();

            GcsOutputChannel writeChannel = gcsService.createOrReplace(filename, options);

            ServletFileUpload upload = new ServletFileUpload();

            res.setContentType("text/plain");             

            try {
                FileItemIterator iterator = upload.getItemIterator(req);

                    while (iterator.hasNext()) {
                        FileItemStream item = iterator.next();
                        InputStream stream = item.openStream();

                        if (item.isFormField()) {
                          log.warning("Champs texte avec id: " + item.getFieldName()+", et nom: "+Streams.asString(stream));
                        } else {
                          log.warning("Nous avons un fichier à uploader : " + item.getFieldName() +
                                      ", appelé = " + item.getName());

                          // You now have the filename (item.getName() and the
                          // contents (which you can read from stream). Here we just
                          // print them back out to the servlet output stream, but you
                          // will probably want to do something more interesting (for
                          // example, wrap them in a Blob and commit them to the
                          // datastore).
                          // Open a channel to write to it


                          byte[] bytes = ByteStreams.toByteArray(stream);

                          try {
                                writeChannel.write(ByteBuffer.wrap(bytes));
                          } finally {
                                writeChannel.close();
                                stream.close();
                          }        
                        }        
                  }
                } catch (FileUploadException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



         }