abstract class Parent {
  public void job() {
    try {
      doJob();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected abstract void doJob();
}

class Child1 extends Parent {
  @Override protected void doJob() {
    /* implementation */
  }
}