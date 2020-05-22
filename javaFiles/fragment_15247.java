@Entity
@Inheritance
@DiscriminatorColumn(name = "discr")
public abstract class X {
    Integer id; 
    // ...
}