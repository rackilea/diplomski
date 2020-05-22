public class Demo {

public interface Projection {
    interface Element {
        @XBRead("./userField")
        List<String> getUserFieldValues();
    }

    @XBRead("//element")
    List<Projection.Element> getElements();
}

public static void main(final String[] args) throws IOException {
    Projection projection = new XBProjector().io().url("resource://data.xml").read(Projection.class);
    for (Projection.Element element : projection.getElements()) {
        for (String userField : element.getUserFieldValues()) {
            System.out.println(userField);
            }
        }
    }
}