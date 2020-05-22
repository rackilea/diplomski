@Entity
public class ActionSet {

    @OneToMany(mappedBy = "actionSet")
    List<ActionSetAction> action;
}