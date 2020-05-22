@Entity
@Table(name="employee")
@TypeDefs(value={@TypeDef(name="inetType",typeClass=InetType.class)})
public class Employee {

    @Column(name="ipadres")
    @Type(type="inetType")
    private String ipadres;