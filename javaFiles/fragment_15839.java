public class Automata {
  List<String> someList;
  boolean someBoolean;
  private State currentState;

  public void performAction() {
    currentState = currentState.action(this);
  }

  interface State {
    State action(Automata context);
  }

  enum States implements State {
    IDLE {
      @Override
      public State action(Automata context) {
        if (context.someBoolean) {
          return WORKING;
        }
        return this;
      }
    },
    WORKING {
      @Override
      public State action(Automata context) {
        if (context.someList.size() > 7) {
          return IDLE;
        }
        return this;
      }
    }
  }
}