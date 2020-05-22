@Override
public Response uploadData(DataUploadForm uploadForm) {

    System.out.printf("Incoming xml data: %s\n", uploadForm.getXML());
    System.out.printf("Incoming binary data: %s\n", uploadForm.getFileStream());

    // Processing the input stream. For example, by using Apache Commons IO
    final byte[] data ;
    try {
       data = IOUtils.toByteArray(uploadForm.getFileStream());
    } catch (IOException ioe) {
       throw new WebApplicationException("Could not read uploaded binary data");
    }

    return Response.ok().build();
}