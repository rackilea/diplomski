class CollaboratorState implements Serializable {
    private String anyName;
    // accessors
}

@RequestScoped
class Collaborator implements HasState<CollaboratorState> {
    // you get the point...
}