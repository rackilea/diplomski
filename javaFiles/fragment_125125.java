public class ReadXMLFileJaxb {
    public static void main(String[] args) {
        File file = new File(ReadXMLFileDOM.class.getClassLoader().getResource("book.xml").getFile());

        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Book book = (Book) unmarshaller.unmarshal(file);
            System.out.println(book.getPerson().size());

            for (int i = 0; i < book.getPerson().size(); i++) {
                System.out.println("------------");
                System.out.println(book.getPerson().get(i).getFirst());
                System.out.println(book.getPerson().get(i).getLast());
                System.out.println(book.getPerson().get(i).getAge());
            }

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
}