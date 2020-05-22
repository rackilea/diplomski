private ObjectProvider<Step1> stepProvider;

public Service(ObjectProvider<Step1> step1Provider) {
    this.stepProvider = stepProvider;
}

public void start() {
    Step1 step1 = step1Provider.getObject("a", "b");
    step1.do();
}