@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Config {
    @XmlElement(name="instance", required = true)
    protected List<Instance> instances;

    public List<Instance> getInstances() {
        return instances;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Instance {
    protected String hostName;
    protected String port;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String value) {
        this.hostName = value;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String value) {
        this.port = value;
    }
}


public static void main(String[] args) throws Exception {
    JAXBContext jc = JAXBContext.newInstance(Config.class);
    Config config = (Config)jc.createUnmarshaller().unmarshal(new File("1.xml"));
    List<Instances> list = config.getInstances();
    list.get(0).setPort(555);
    list.get(1).setHostName("192.168.3.140");
    list.get(2).setPort(168);
    list.get(2).setHostName("192.168.1.168");

    Marshaller m = jc.createMarshaller();
    m.marshal(config,  filex);