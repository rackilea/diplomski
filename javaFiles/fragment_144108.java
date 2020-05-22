public interface Strategy {
    void execute();
}

public class SomeStrategy implements Strategy {
    public void execute() {
        System.out.println("Some logic.");
    }
}