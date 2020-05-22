private ObservableSet<PseudoClass> states;  // <=== strong ref

@Override
public void start(Stage stage) throws Exception {
    Button horse = new Button("horse");

    states = horse.getPseudoClassStates();
    states.addListener(new InvalidationListener() {
        @Override
        public void invalidated(Observable arg0) {
            System.out.println("invalidated " + arg0);
        }
    });