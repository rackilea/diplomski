class SomeVariables {
    private String s;
    private int dontneed;

    // Constructor method
    public SomeVariables() {
        // Initialize your attributes
    }

    public String getValue() {
        return s;
    }

    public void setValue(String value) {
        s = value;
    }
}

class MainClass {
    public static void main(String[]args){
        SomeVariables vars = new SomeVariables();

        vars.setValue("Some value");

        System.out.println(vars.getValue());
    }
}