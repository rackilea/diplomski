public class LearnerFactory {

    public static Learner getInstance(
        Class<? extends Learner> learner) throws IllegalAccessException, InstantiationException {

        return learner.newInstance();
    }
}

public class MyClass {

    private boolean historic;

    private Learner learner;

    public MyClass(boolean historic,
        Class<? extends Learner> learner) throws IllegalAccessException, InstantiationException {
        this.learner = LearnerFactory.getInstance(learner);
        this.historic = historic;
    }

    public void process() {
        ...
    }
}