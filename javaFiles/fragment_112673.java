@Entity
@Access(AccessType.FIELD)
@Table(name="test_my_entity")
public class MyEntity {

    @Id
    @GeneratedValue
    private Long id;

    @XmlAttribute(name = "name")
    @Transient
    protected String name;

    @XmlSchemaType(name = "dateTime")
    @Transient
    protected XMLGregorianCalendar myXMLDate;

    @Transient
    private Calendar calendarDate;

    @Access(AccessType.PROPERTY)
    @Column(name = "calendar_date")
    private Calendar getCalendarDate() {
        return new GregorianCalendar(myXMLDate.getYear(), myXMLDate.getMonth(), myXMLDate.getDay());
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "my_str_name")
    public String getName() {
        return "My string";
    }

    //...setters here

    public MyEntity() {
    }
}