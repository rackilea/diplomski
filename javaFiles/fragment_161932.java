@Entity
public class Driver {    
    @Id @GeneratedValue private Integer id;
    @OneToMany private List<License> licenses;
    ... Driver Name, Number, & DateOfBirth ...
}