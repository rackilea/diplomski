class CompositeA implements Composite {
  public ? process() {
    for (Sub subItem : subItems) {
      subItem.execute();
      subItem.postProcess(this);
    }
  }

  public ? postProcessA(SubA subItem) {
    //do something with SubA
  }

  public ? postProcessB(SubB subItem) {
    //do something with SubB
  }
}

class CompositeB implements Composite {
  public ? process() {
    for (Sub subItem : subItems) {
      subItem.execute();
      subItem.postProcess(this);
    }
  }

  public ? postProcessA(SubA subItem) {
    //do something else with SubA
  }

  public ? postProcessB(SubB subItem) {
    //do something else with SubB
  }
}

class SubA implements Sub {
  public ? execute() {
    //doSomething
  }

  public ? postProcess(Composite composite) {
    comp.postProcessA(this);
  }
}

class SubB implements Sub {
  public ? execute() {
    //doSomething
  }

  public ? postProcess(Composite composite) {
    comp.postProcessB(this);
  }
}