class SomeServiceState implements Serializable {
    private String someData;
    private Long someId;
    private List<String> list;
    private CollaboratorState collaboratorState;
    // accessors
}

@RequestScoped
public class SomeService implements HasState<SomeServiceState> {

    // COLLABORATORS
    @Inject
    Collaborator collaborator; // assume it's needed

    // INTERNAL STATE
    private String someData;
    private Long someId;
    private List<String> list = new ArrayList<>();

    public void add() {
        list.add("S");
    }

    // ...

    public SomeServiceState getState() {
        SomeServiceState state = new SomeServiceState();
        state.setSomeData(someData);
        state.setSomeId(someId);
        state.setList(new ArrayList<>(list)); // IT IS PROBABLY SAFER TO COPY STATE!
        // SEE HOW STATE GETS EXTRACTED RECURSIVELY:
        state.setCollaboratorState(collaborator.getState());
        return state;
    }

    public void setState(SomeServiceState state) {
        someData = state.getSomeData();
        someId = state.getSomeId();
        list = new ArrayList<>(state.getList());
        // SEE HOW STATE GETS APPLIED RECURSIVELY:
        collaborator.setState(state.getCollaboratorState());
    }
}