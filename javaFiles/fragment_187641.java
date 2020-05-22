@GET
        @Produces(MediaType.APPLICATION_XML)
        public Response gofindsaxbooks()
        {

            return Response.status(200).entity("Test XML created").build();
        }