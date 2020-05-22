public static class Step {
    public void doWork(Subject subject) {
       //do Subject stuff
    }
}

public static class Worker {
    public static void doWork(Subject subject, List<Step> steps) {
        for (Step step : steps) {
            step.doWork(subject);
        }
    }
}

public static void main(String[] args) {

    List<Step> steps = ...;

    //all valid
    Worker.doWork(new Subject(), steps);
    Worker.doWork(new MySubject(), steps);
    Worker.doWork(new MyOtherSubject(), steps);
}