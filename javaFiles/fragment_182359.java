public class ElementExists {

    public interface Projection {

        interface Element {
            @XBRead("./@hash")
            String getHash();

            @XBRead("count(./userField)>0")
            boolean hasUserField();
        }

        @XBRead("//element")
        List<Element> getElements();
    }

    public static void main(final String[] args) throws IOException {
        Projection projection = new XBProjector().io().url("resource://data.xml").read(Projection.class);
        for (Projection.Element e : projection.getElements()) {
            System.out.print("Element with hash '" + e.getHash() + "' has ");
            System.out.println((e.hasUserField() ? "" : "no ") + "user field");
        }
    }
}