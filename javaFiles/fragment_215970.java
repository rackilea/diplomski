@Entity
@IdClass(EmployeeTerritoryFunctionPK.class)
public class EmployeeTerritoryFunction implements Serializable {

    @Id
    @ManyToOne
    private Employee employee;

    @Id
    @ManyToOne
    private Territory territory;
}

public class EmployeeTerritoryFunctionPK implements Serializable {
    private Employee employee;
    private Territory territory;

    public int hashCode() { //TODO }
    public boolean equals(Object obj) { //TODO }

}