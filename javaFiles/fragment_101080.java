@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typeName")
@JsonSubTypes({
        @Type(value = BooleanValueEvent.class),
        @Type(value = ExactValueEvent.class)
})
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "EVENT_TYPE")
public abstract class Event implements Cloneable, Serializable {
    @Id
    @GeneratedValue
    private Long id;
...
}