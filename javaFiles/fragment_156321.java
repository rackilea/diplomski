String name="";
String email="";
long whatsapp=0;
long number=0;
String query="";
int flag1=0;
int flag2=0;
boolean isMultipart = ServletFileUpload.isMultipartContent(req);
resp.setContentType("text/html");
java.io.PrintWriter out = resp.getWriter( );
    if( !isMultipart ) {
   out.println("<html>");
   out.println("<head>");
   out.println("<title>Servlet upload</title>");  
   out.println("</head>");
   out.println("<body>");
   out.println("<p>No file uploaded</p>"); 
   out.println("</body>");
   out.println("</html>");
   return;
}

DiskFileItemFactory factory = new DiskFileItemFactory();

// maximum size that will be stored in memory
factory.setSizeThreshold(maxMemSize);

// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload(factory);

// maximum file size to be uploaded.
upload.setSizeMax( maxFileSize );

try { 
   // Parse the request to get file items.
   List fileItems = upload.parseRequest(req);

   // Process the uploaded file items
   Iterator i = fileItems.iterator();

   out.println("<html>");
   out.println("<head>");
   out.println("<title>Servlet upload</title>");  
   out.println("</head>");
   out.println("<body>");

   while ( i.hasNext () ) {
      FileItem fi = (FileItem)i.next();
      if ( !fi.isFormField () ) {
         // Get the uploaded file parameters
        try { String fieldName = fi.getFieldName();
         String fileName = fi.getName();
         String contentType = fi.getContentType();
         boolean isInMemory = fi.isInMemory();
         long sizeInBytes = fi.getSize();
         Date date=new Date();             
         System.out.println(("Uploaded Filename: " + fileName + "<br>"));
         flag1=1;
         File f1=new File("C:\\Users\\Subhanshu Bigasia\\Desktop\\amazon2.pdf");
         FileInputStream fileInputStream = (FileInputStream) fi.getInputStream();
         Storage storage = StorageOptions.getDefaultInstance().getService();
         Bucket bucket=storage.get(("combucket1eduvitae7"));
         ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
         BlobId blobId = BlobId.of("combucket1eduvitae", "my_blob_name1");
         //Blob blob = bucket.create("my_blob_name1", targetFileStr.getBytes(), "application/pdf");
         Blob blob=bucket.create(fileName+" "+date.toString(),fileInputStream,"application/pdf");
         flag1=1;
        }
        catch(Exception e) {
            flag1=0;
            e.printStackTrace();
        }
      }