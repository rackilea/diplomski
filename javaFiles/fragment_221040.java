public void insert(Project entity) {
    Project pr = new Project();
    pr.setName("pr1");
    //-Create a Layer-
    Layer testLayer = new Layer();
    testLayer.setIdLayer(1);
    testLayer.setLayerName("Layer 1");
    //Add that layer to your Project's list by first getting it and then calling add method on it.
    pr.getLayer().add(testLayer);
    try {
        JAXBContext jc = JAXBContext.newInstance(Project.class);
        javax.xml.bind.Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
        File XMLfile = new File("Projects" + "//" + pr.getName() + "//" +"ProjectDataBase.xml");
        marshaller.marshal(pr, XMLfile);
    } catch (JAXBException e) {
        e.printStackTrace();
    }
}