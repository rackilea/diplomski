public class Main {

public static void main(String[] args)
        throws IOException {

    URL url = Main.class.getClassLoader().getResource("test.html");
    Source source = new Source(url);
    List<Element> elementList = source.getAllElements("test:name");
    for (Element element : elementList) {
        System.out.println("Custom tag content: " + element.getContent().toString());
    }
}