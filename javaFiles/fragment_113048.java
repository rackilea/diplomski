@Entity
public class Student extends Model {

    @Id
    public Integer id;

    @OneToMany(mappedBy="student")
    public List<Bridge> bridges;

    public static Finder<Integer,Student> find = new Finder<Integer,Student>(
        Integer.class, Student.class
    ); 
}