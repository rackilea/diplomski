class Controller {

  /** Returns a list of the configured action objects. */
  public static List<Action> buildActions() {
    List<Action> actions = new LinkedList<Action>();
    actions.add(new Assemble(parameter));  // or whathever parameters you need
    actions.add(new Start(parameter1, parameter2));
    actions.add(new Ignite());
    actions.add(new Move());
  }

  /** Build the list of actions and run one after the other. */
  public static void main(String[] args) {
    List<Action> actions = buildActions();
    for (Action action: actions) {
      action.run();
      // here you could add logging, profiling etc. per Action.
    }
  }
}