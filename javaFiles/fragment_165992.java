@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Teacher {
// ...
@ManyToOne(optional = false)
@JsonBackReference(value = "teachers")
private School school;