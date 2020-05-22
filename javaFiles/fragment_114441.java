public static void main(String[] args) {
     Circle circle = new Circle();
      circle.setRadius(5);
      circle.setId(1234);
      try {

        File file = new File("Y:\\file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Circle.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(circle, file);
        jaxbMarshaller.marshal(circle, System.out);

          } catch (JAXBException e) {
        e.printStackTrace();
          }
}