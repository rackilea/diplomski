public class Employee {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idEmp;

  @NotEmpty
  @Size(min = 5, message="At least five characters needed")
  private String employeeName;

  @NotNull
  @Valid 
  private Departement departement;
}