class Parameters {
    @XmlElement(name = "item")
    public List<Item> items;
}

class Item {
    public String fileName;
    public String contentType;
}