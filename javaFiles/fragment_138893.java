public class ReadXMLUsingJAXB {

    static class Catalog {
        @XmlElement(name = "book")
        List<Book> books;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Book {
        @XmlAttribute
        int id;
        String author;
        String title;
        String genre;
        int price;
        Date publish_date;
        String description;
    }

    private static Book firstBookFromXML() {
        Catalog catalog = JAXB.unmarshal(new File("PATH"), Catalog.class);
        return catalog.books.get(0);
    }

    public static void main(String[] args) {
        Book book = firstBookFromXML();
        System.out.println(book.id + ", " + book.author + ", " + book.title 
                + ", " + book.genre + ", " + book.price 
                + ", " + book.publish_date + ", " + book.description);
    }

}