@MappedSuperclass
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Table(name = "state")
public class StateBase {

    /**
     * Entity API
     */
    @Id
    @Column(name = "id")
    private String id = this.getClass().getSimpleName(); //prevent from creating two instances of state

    @Column(name = "name")
    private String name;

    @Column(name = "badgeColor")
    private String badgeColor;

    //only Getters! also hashCode and Equals
    //.....................

    /**
     * ======== State API ========
     * Use TEMPLATE METHOD and hooks
     */
    final public void changeState(Session session, State newState, StateEntity entity) { //StateEntity is interface that is implemented by all entities that have a state
        if(newState.equals(this)) return;

        if (canMove(session, newState, entity)) {
            hook(session, newState, entity);
            beforeTransition(session, newState, entity);
            makeTransition(session, newState, entity);
            afterTransition(session, newState, entity);
        } else {
            throw new TransitionDeniedException("Transition from " + getName() + " to " + newState.getName() + " is denied.");
        }
    }

    //Defauls implementation for all (or almost all hooks)
    protected void beforeTransition(Session session, State newState, StateEntity entity) {
        entity.setState(newState);
    }

    protected void afterTransition(Session session, State newState, StateEntity entity) {
        writeHistory(entity);
       session.merge(entity);
    }
    //..........................
}