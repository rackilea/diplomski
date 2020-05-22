<!-- language: java --> 
 public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(IGEType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File XMLfile = new File("sample1.xml");
        IGEType igeRoot = (IGEType) jaxbUnmarshaller.unmarshal(XMLfile);

        List<ALTINType> listAltinRoot = igeRoot.getALTIN();

        // here you ll be have error ///
//            List<SEANSytlType> listofAltinYtl =  (List<SEANSytlType>)      listAltinRoot.get(0);
//
//            for (SEANSytlType altinYtl : listofAltinYtl) {
//              System.out.println(altinYtl.birim);
//            }

    } catch (JAXBException e) {

        e.printStackTrace();
    }
}