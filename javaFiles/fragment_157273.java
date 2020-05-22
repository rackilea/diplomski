@XmlRootElement
class Customer {

    private String name;

    private String date;

    private long dateTimestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date; // You can do additional transformations here
        try {
            this.dateTimestamp = new SimpleDateFormat("MM/dd/yy").parse(date).getTime();
        } catch (ParseException e) {
            // Handle this appropriately ;-)
        }
    }

    public long getDateTimestamp() {
        return dateTimestamp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("date='" + date + "'")
                .add("dateTimestamp=" + dateTimestamp)
                .toString();
    }

}

public class XmlUnmarshaller {

    private static final String XML_STRING =
            "<customer>\n" +
            "    <name>john</name>\n" +
            "    <date>10/10/18</date>\n" +
            "</customer>";

    public static void main(String[] args) {

     try {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(XML_STRING.getBytes(StandardCharsets.UTF_8)));
        System.out.println(customer);

      } catch (JAXBException e) {
        e.printStackTrace();
      }
    }

}