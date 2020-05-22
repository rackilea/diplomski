public class Bar extends MouseAdapter {
    public interface Caller {
        void thingClicked();
        ...
    }
}

public class Foo extends JPanel implements Bar.Caller {
    ...
}