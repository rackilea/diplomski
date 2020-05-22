@ManagedBean
@ViewScoped
public class Bean implements Serializable {

    private List<Input> inputs;

    @PostConstruct
    public void init() {
        inputs = new ArrayList<Input>();
    }

    public void add() {
        Input input = new Input();
        input.setLabel("Input " + (inputs.size() + 1));
        inputs.add(input);
    }

    public List<Input> getInputs() {
        return inputs;
    }

}