public class ItemsTest {

    @Test
    public void testXml() throws JAXBException, IOException {

        final Items marshallable = Plural.newInstance(Items.class);
        for (int i = 0; i < 5; i++) {
            marshallable.getItems().add(Item.newInstance(i, "name" + i));
        }
        for (Item item : marshallable.getItems()) {
            System.out.println("marshallable.item: " + item);
        }

        final JAXBContext context = JAXBContext.newInstance(Items.class);

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        marshaller.marshal(marshallable, baos);
        baos.flush();

        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Items unmarshalled = (Items) unmarshaller.unmarshal(
            new ByteArrayInputStream(baos.toByteArray()));
        for (Item item : unmarshalled.getItems()) {
            System.out.println("unmarshalled.item: " + item);
        }
    }
}