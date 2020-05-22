@Entity
public class Action {

    @OneToMany(mappedBy = "action")
    List<ActionSetAction> action;
}