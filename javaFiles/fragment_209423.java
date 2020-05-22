@Entity @Table(name = "employee") 
public class Employee { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 // Remaining fields 
@Transient
private String imageDecode;
}