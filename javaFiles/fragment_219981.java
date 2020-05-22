@PUT
@Path("/{isbn}")
@Consumes("application/x-www-form-urlencoded")
@Produces(MediaType.APPLICATION_XML)
public SuccessfulRequestMessage createBook(@FormParam("code") String code,
        @PathParam("isbn") String isbn) throws MyWebServiceException {

    if(code == null || code.length() == 0)
    {
        ErrorMessage errorMessage = new ErrorMessage("400 Bad request",
                "Please provide the values for the book you want to create!");
        throw new MyWebServiceException(Response.Status.BAD_REQUEST,
                errorMessage);
    }

    //create the JAXBElement corresponding to the XML code from inside the string
    JAXBContext jc = null;
    Unmarshaller unmarshaller;
    JAXBElement<Book> jaxbElementBook = null;
    try {
        jc = JAXBContext.newInstance(Book.class);
        unmarshaller = jc.createUnmarshaller();
        StreamSource source = new StreamSource(new StringReader(code));
        jaxbElementBook = unmarshaller.unmarshal(source, Book.class);
    } catch (JAXBException e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }