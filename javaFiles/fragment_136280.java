private void yourMethod(Resource resource) {
    try (
        ACBinaryWrapper acbinary = new ACBinaryWrapper(
            resource.getValueMap().get("jcr:data", Binary.class)
        );
        InputStream is = acbinary.getBinary().getStream();
    ) {
        // ...do something with the InputStream...
    } catch (IOException e) {
        // ...appropriate handling...
    } catch (RepositoryException e) {
        // ...appropriate handling...
    }
}