@Entity
public class Course extends Model {

    @Id
    public Integer id;

    @OneToMany(mappedBy="course")
    public List<Bridge> bridges;

    public static Finder<Integer,Course> find = new Finder<Integer,Course>(
        Integer.class, Course.class
    ); 
}