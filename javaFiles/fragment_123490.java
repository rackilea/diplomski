@Entity
@Table(name = "employmentinformationview")
public class EmploymentInformationView implements Serializable {

    @EmbeddedId
    @AttributeOverride(name="infoId", column=@Column(name="InfoID")
    @AttributeOverride(name="empId", column=@Column(name="EmpID")
    EmploymentViewId id;

    ...

}