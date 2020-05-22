import java.util.List;

public class ABC {
    public void doSomething(String path, List<SomeObject> objects) {
        System.out.println("Doing something with many objects");
        for (SomeObject obj : objects) {
            doSomething(path, obj);
        }
    }

    public void doSomething(String path, SomeObject obj) {
        System.out.println("Doing something with: " + obj.what);
    }
}