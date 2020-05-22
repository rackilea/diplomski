public enum State {
  INITIAL,
  MIDDLE,
  FINAL;
  public static State initial() {
    return INITIAL;
  }

}

// A 'null' for the Character matches anything.
static Map<Pair<State,Character>, State> machine = new HashMap<>();
static {
  // Always transit from INITIAL to MIDDLE
  machine.put(new Pair<State,Character>(State.INITIAL,null), State.MIDDLE);
  // An 'a' transitrs us to FINAL
  machine.put(new Pair<State,Character>(State.MIDDLE,'a'), State.FINAL);
  // Anything else takes us back to INITIAL
  machine.put(new Pair<State,Character>(State.MIDDLE,null), State.FINAL);
  // Stay in FINAL once there.
  machine.put(new Pair<State,Character>(State.FINAL,null), State.FINAL);

}