@Entity
public class College {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int collegeId;
    @OneToMany(mappedBy="college") // here non-owning side using mapped by elment to specify
                                   // the relationship field of owning side
    private List<Student> students;
    }


Owning Side Object

@Entity
public class Student {
@ManyToOne
    private College college;
}