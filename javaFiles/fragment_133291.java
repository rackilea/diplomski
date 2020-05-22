public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            List<BlobKey> blobs = blobstoreService.getUploads(req).get("file");
            BlobKey blobKey = blobs.get(0);

            ImagesService imagesService = ImagesServiceFactory.getImagesService();
            ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKey);
            servingOptions.secureUrl(true);
            String servingUrl = imagesService.getServingUrl(servingOptions);

            res.setStatus(HttpServletResponse.SC_OK);
            res.setContentType("text/plain");

            PrintWriter out = res.getWriter();
            out.print(servingUrl);
            out.flush();
            out.close();
    }