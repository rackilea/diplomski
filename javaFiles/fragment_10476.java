public class GUI {
private static GUI ourInstance = new GUI();

public static GUI getInstance() {
    return ourInstance;
}

private GUI() {
    //private constructor
}
public void method() {}
}