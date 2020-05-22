import java.util.Vector;

public class A implements I {

    private String id;
    private Vector<String> inputs;
    private Vector<String> outputs;

    @Override
    public void createMyXML() {
        System.out.println("Create XML by the rules of A.");
    }

    /* Getters and setters and other methods needed*/
}