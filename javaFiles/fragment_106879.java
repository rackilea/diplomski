import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AllMyData data = new AllMyData();
        data.add("foo", new MyData("Hello World", "", 1));
        data.add("cli", Arrays.asList(new MyData("BASH", "", 2), new MyData("SHELL", "", 3)));
        System.out.println(data);
    }
}