@Entity  
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public abstract class PersonEntity {

    @Id
    @GeneratedValue
    @Column(name="id")      
    private Integer id;

    @Column(name="name")        
    private String name;

    @Column(name="description")         
    private String desciption;

    @Column(name="type", insertable = false, updatable = false)         
    private String type;    

    //getters and setters
}

@Entity
@Table(name = "person")
@DiscriminatorValue("child")
public class ChildEntity extends PersonEntity { 

}

@Entity
@Table(name = "person")
@DiscriminatorValue(value="man")
public class ManEntity extends PersonEntity {

}

@Entity  
@Table(name = "person")
@DiscriminatorValue(value="woman")
public class WomanEntity extends PersonEntity {

}