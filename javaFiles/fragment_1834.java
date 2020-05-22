import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class JaxbStuff {
    public static void main(String[] args) throws Exception {
        MessageRS message = new MessageRS();
        message.setUserId(10);
        MessageRS.Bucket bucket1 = new MessageRS.Bucket();
        bucket1.setText("This is sample text");
        bucket1.setChannels(Arrays.asList("Test A", "Test B"));
        MessageRS.Bucket bucket2 = new MessageRS.Bucket();
        bucket2.setText("Some more text");
        bucket2.setChannels(Arrays.asList("1", "2"));
        message.setBuckets(Arrays.asList(bucket1, bucket2));
        StringWriter writer = new StringWriter();
        JAXBContext.newInstance(MessageRS.class).createMarshaller().marshal(message, writer);
        System.out.println(writer);
    }

    @XmlRootElement(name = "message")
    static class MessageRS {

        public static class Bucket {
            private List<String> channels;
            private String text;

            private Bucket() {}

            @XmlElementWrapper(name = "channels")
            @XmlElement(name = "channel")
            public List<String> getChannels() {
                return channels;
            }

            public void setChannels(List<String> channels) {
                this.channels = channels;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        private List<Bucket> buckets;

        private Long userId;

        private MessageRS() { }

        public List<Bucket> getBuckets() {
            return buckets;
        }

        public void setBuckets(List<Bucket> buckets) {
            this.buckets = buckets;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long UserId) {
            this.userId = UserId;
        }
    }

}