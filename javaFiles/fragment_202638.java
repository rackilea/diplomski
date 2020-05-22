public interface SomethingWrapper {
    public String getValueOne();
    public void setValueOne(String valueOne);
    public String getValueTwo();
    public void setValueTwo(String valueTwo);
};

public class SomethingAWrapper implements SomethingWrapper {

    private SomethingA someA;

    public SomethingWrapper(SomethingA someA) {
        this.someA = someA;
    }

    public String getValueOne() {
        return this.someA.getValueOne();
    }

    public void setValueOne(String valueOne) {
        this.someA.setValueOne(valueOne);
    }

    public String getValueTwo() {
        return this.someA.getValueTwo();
    }

    public void setValueTwo(String valueTwo) {
        this.someA.setValueTwo(valueTwo);
    }
};