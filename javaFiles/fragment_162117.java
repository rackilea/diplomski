Object readFrom(Class<Object>, Type genericType,
                  Annotation annotations[], MediaType mediaType,
                  MultivaluedMap<String, String> httpHeaders,
                  InputStream entityStream)
                         throws IOException, WebApplicationException {

      try {
         JAXBContext ctx = JAXBContext.newInstance(type);
         StringWriter writer = new StringWriter();
         IOUtils.copy(inputStream, writer, encoding);
         String theString = writer.toString();
         // replace all special characters
         theString = theString.replaceAll("[\u0000-\u001f]", "");
         return ctx.createUnmarshaller().unmarshal(theString);
      } catch (JAXBException ex) {
        throw new RuntimeException(ex);
      }
   }