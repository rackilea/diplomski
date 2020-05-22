public static void main(String[] args) throws JAXBException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarhsaller = jaxbContext.createUnmarshaller();
        Root root = (Root) unmarhsaller.unmarshal(new File("pathToYourFile.xml"));
       Listof_aaa listof_aa = root.getListof_aaa();

       /* and in case of a list */
       List<Listinside> listinside = root.getListinside();
       for (List myList : listinside) {
           // do your stuff
       }
}