import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

public class XmlSample {

    public static void main(String[] args) {
        XStream xStream = new XStream();
        Converter converter = new ToAttributedValueConverter(Message.class,
                xStream.getMapper(), xStream.getReflectionProvider(), xStream.getConverterLookup(), "text");
        xStream.registerConverter(converter);
        xStream.alias("message", Message.class);
        System.out.println(xStream.toXML(new Message("testtest")));
    }

    public static final class Message {
        private final String text;

        // Needed for XStream serialization
        @SuppressWarnings("unused")
        private Message() {
            text = null;
        }

        public Message(final String text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }
}