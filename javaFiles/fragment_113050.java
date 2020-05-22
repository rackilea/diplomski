@Entity
public class Bridge extends Model {

    @Id
    public Integer id;

    @ManyToOne public Student student;

    @ManyToOne public Course course;

    public String additional_field;

    public static Finder<Integer,Bridge> find = new Finder<Integer,Bridge>(
        Integer.class, Bridge.class
    ); 
}