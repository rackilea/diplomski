@Entity
    public class User { 
    private int id;
    private Strng name;

    @OneToMany(mappedBy ="user" )
    @Filter(name="filterDeleted")
    private Collection<Details> details;//= new ArrayList<Details>();
    ....getters and setters.....
   }