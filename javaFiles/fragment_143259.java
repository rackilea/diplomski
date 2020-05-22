@XmlRootElement(name = "phone")
static class Phone {
    @XmlElement(name = "area")
    @Column(name = "area")
    int area;
    @XmlElement(name = "number")
    @Column(name = "number")
    int number;

    // here area = 111
    // pnumber = 123-4567
}