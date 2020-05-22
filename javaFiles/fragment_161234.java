@POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/xml")
    public Response uploadFile(...){
         //body
   }