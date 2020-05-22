@XmlElements({
    @XmlElement(type=AndQuery.class),
    @XmlElement(type=OrQuery.class),
    @XmlElement(type=NotQuery.class),
    @XmlElement(type=PropertyQuery.class),
    @XmlElement(type=MultiQuery.class)
})
List<Query> queries;