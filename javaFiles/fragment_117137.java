public class Example implements Comparable<Example> {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    @Override
    public int compareTo(Example o) {
        return this.test.compareTo(o.test);
    }

}