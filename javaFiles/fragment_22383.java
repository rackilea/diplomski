@Entity
public class ActionSet {

    @OneToMany(mappedBy = "action")
    @Where(clause="is_important = true")
    List<ActionSetAction> importantActions;

    @OneToMany(mappedBy = "action")
    @Where("is_important = false")
    List<ActionSetAction> unimportantActions;
}