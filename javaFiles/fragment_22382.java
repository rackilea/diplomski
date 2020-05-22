@Entity
public class ActionSetAction {

    @ManyToOne
    @JoinColumn(name = "action_set_id")
    private ActionSet actionSet;

    @ManyToOne
    @JoinColumn(name = "action_id"
    private Action action;

    @Column(name ="is_important"
    private boolean important;
}