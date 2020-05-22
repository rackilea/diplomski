@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
@ApiOperation(value = "Get a scheduled process by id.",notes = "This is note ;)",response = NamesContainer.class,code = HttpURLConnection.HTTP_OK, produces="text/html" /*add produces->xml*/)
@ApiResponses(value = {@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "set in case of success. Returns the requested scheduled process",  response = NamesContainer.class)})

public Response sayHello(HttpServletResponse response) {
    switch (request.getHeader("accept"))
    {

        case MediaType.APPLICATION_XML:

            response = Response.ok().entity(/*yourEntity here (for me it was NamesContainer)*/).type(MediaType.APPLICATION_XML).build();
            break;

        case MediaType.TEXT_HTML:

            response = Response.ok().entity(/*Transform xml to HTML with xsl and return it here as String*/).type(MediaType.TEXT_PLAIN).build();
            break;
    }
}