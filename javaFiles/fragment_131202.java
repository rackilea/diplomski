T doSomething() {
  try {
    return someMethodThatCouldThrowAnything();
  } catch (IKnowWhatToDoWithThisException e) {
    return handle(e);
  } catch (Throwable t) {
    throw Throwables.propagate(t);
  }
}