@Test
public void testCollectionToIntMapping() {
    List<String> mappingFiles = new ArrayList<String>();
    mappingFiles.add("com/mycompany/samples/dozer/somedozermapping.xml");
    Mapper mapper = new DozerBeanMapper(mappingFiles);

    Source sourceObject = new Source();
    sourceObject.setImages(Arrays.asList( "a", "b", "C" ));

    Destination destObject = mapper.map(sourceObject, Destination.class);

    assertEquals(3, destObject.getNumOfImages());
}