public class Test {
Test2 t;
public static void main(String[] args) {
    Test test = new Test();
    test.t = new Test2("Joe");  
   test.displayName();
}

public void displayName() {
    System.out.println("Name2: " + t.name);
}
}