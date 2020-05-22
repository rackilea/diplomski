@Entity
@Table(name="EMPLOYEE")
@SecondaryTable(name="EMP_DATA",
                pkJoinColumns = @PrimaryKeyJoinColumn(name="EMP_ID", referencedColumnName="ID")
               )
public class Employee {
    ...
    @Column(name="YEAR_OF_SERV", table="EMP_DATA")
    private int yearsOfService;

    @OneToOne
    @JoinColumn(name="MGR_ID", table="EMP_DATA", referencedColumnName="ID")
    private Employee manager;
    ...
}