import java.io.ByteArrayOutputStream;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.io.PrintWriter;

    import javax.xml.bind.JAXBContext;
    import javax.xml.bind.Marshaller;
    import javax.xml.bind.Unmarshaller;
    import javax.xml.bind.annotation.XmlRootElement;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    @XmlRootElement(name = "Fruit")
    public class Fruit {

        public final static String  XML_FILE    = "fruit.xml";
        public final static String  JSON_FILE   = "fruit.json";

        public static Fruit fromJson(InputStream in) {
            Gson gson = new GsonBuilder().create();
            Fruit result = gson.fromJson(new InputStreamReader(in), Fruit.class);
            return result;
        }

        public static Fruit fromXML(InputStream in) throws Exception {
            JAXBContext context = JAXBContext.newInstance(Fruit.class);
            Unmarshaller um = context.createUnmarshaller();
            return (Fruit) um.unmarshal(in);
        }

        public static void main(String[] args) throws Exception {

            Fruit f = new Fruit("Apple", "Red", "Sweet");
            Fruit f2 = new Fruit("Durian", "White", "Don't ask");

            System.out.println(f.toXML());
            System.out.println(f2.toJSON());

            f.saveXML(new FileOutputStream(new File(XML_FILE)));
            f2.saveJSON(new FileOutputStream(new File(JSON_FILE)));

            Fruit f3 = Fruit.fromXML(new FileInputStream(new File(XML_FILE)));
            System.out.println(f3.toJSON());

            Fruit f4 = Fruit.fromJson(new FileInputStream(new File(JSON_FILE)));
            System.out.println(f4.toXML());

        }

        private String  name;
        private String  color;
        private String  taste;

        public Fruit() {
            // Default constructor
        }

        public Fruit(final String name, final String color, final String taste) {
            this.name = name;
            this.color = color;
            this.taste = taste;
        }

        /**
         * @return the color
         */
        public final String getColor() {
            return this.color;
        }

        /**
         * @return the name
         */
        public final String getName() {
            return this.name;
        }

        /**
         * @return the taste
         */
        public final String getTaste() {
            return this.taste;
        }

        public void saveJSON(OutputStream out) throws IOException {
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            gb.disableHtmlEscaping();
            Gson gson = gb.create();
            PrintWriter writer = new PrintWriter(out);
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        }

        public void saveXML(OutputStream out) throws Exception {
            JAXBContext context = JAXBContext.newInstance(Fruit.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this, out);
        }

        /**
         * @param color
         *            the color to set
         */
        public final void setColor(String color) {
            this.color = color;
        }

        /**
         * @param name
         *            the name to set
         */
        public final void setName(String name) {
            this.name = name;
        }

        /**
         * @param taste
         *            the taste to set
         */
        public final void setTaste(String taste) {
            this.taste = taste;
        }

        public String toJSON() throws IOException {
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            gb.disableHtmlEscaping();
            Gson gson = gb.create();
            return gson.toJson(this, Fruit.class);
        }

        public String toXML() throws Exception {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(Fruit.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this, out);
            return out.toString();
        }

    }