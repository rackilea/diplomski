// Class<E> object will be used to create new instances
private final Class<E> stateClass;
// Users will pass the class to StateMachine's constructor
public StateMachine(Entity entity, Class<E> stateClass) {
    this.entity = entity;
    this.stateClass = stateClass;
    states = new ArrayMap<S, E>();
}