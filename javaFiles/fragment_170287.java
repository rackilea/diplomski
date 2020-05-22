@Entity
@Table(name = "PROPERTY")
public class Property extends PropertySuper {

    @Column(name="TYPE_CODE")
    private Integer typeCode;

    ...getters and setters...
}