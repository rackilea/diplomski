@Entity
public class Child extends User{

    //name has to be != then pk_user
    @ManyToOne(optional = false)
    @JoinColumn(name = "pk_father")
    private Father father;

}