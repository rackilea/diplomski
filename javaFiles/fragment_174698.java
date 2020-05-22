@Document
public final class Employee {

    @Id @GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES,delimiter="-")
    private String id;

    @IdAttribute
    private String employeeId;

    @IdSuffix
    private String suffix = "EMPLOYEETYPE";
}