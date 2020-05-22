@XmlRootElement
class Customer {
    @XmlElement
    String name;
    public String toString() {
        return name;
    }
}

@XmlRootElement
class Customers {
    @XmlElement(name = "customer")
    List<Customer> list;
}

class Test {

    public static void main(String[] args) throws Exception {
        String xml = "<customers><customer><name>Ayodeji</name></customer></customers>";
        JAXBContext ctx = JAXBContext.newInstance(Customers.class);
        Unmarshaller um = ctx.createUnmarshaller();
        Customers res = (Customers)um.unmarshal(new StringReader(xml));
        System.out.println(res.list);
    }
}