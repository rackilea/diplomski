public class ClassA implements Addable<Integer> {
    public int add(Integer value) {
        ...
    }
}

public class ClassB implements Addable<String> {
    public int add(String value) {
        ...
    }
}