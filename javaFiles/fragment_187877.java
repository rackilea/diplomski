@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    @XmlElements({
        @XmlElement(name = "comboBox", type = Field.class),
        @XmlElement(name = "numberField", type = Field.class)
    })
    private Field field;
}