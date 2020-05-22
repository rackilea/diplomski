@Entity
 public class Student {

@Id
@GeneratedValue
private Long id;

private String studentName;

@OneToOne(mappedBy = "mealCook")
@JsonBackReference
private Meal meal;