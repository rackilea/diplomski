@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectStorageService objectStorage = authenticateAndGetObjectStorageService();
         System.out.println("Storing file in ObjectStorage...");
        String containerName = "abc";
        String fileName = request.getParameter("nome");

         if (containerName == null || fileName == null) { //No file was specified to be found, or container name is missing
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("File not found.");
            return;
        }

        try {

            Part filePart = request.getPart("fileToUpload"); // Retrieves <input type="file" name="file">  
            InputStream fileContent = filePart.getInputStream();
            Payload<InputStream> payload = new PayloadClass(fileContent);

             objectStorage.objects().put(containerName, fileName,  payload);

            System.out.println("Upload Successful");
        } catch (Exception e) {
            System.out.println(e);
        }

    }