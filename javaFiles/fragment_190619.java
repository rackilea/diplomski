class Example1 {
    int a = 100; // instance variable

    public void printData() { // this an instance method called using an object of class Example1
        getData(); // accessing another instance method directly without any object
    }

    public void getData() {

        System.out.println(a); // accessing instance variable 'a' directly without any object
    }

}

public class InstanceDemo {

public static void main(String[] args) {
    Example1 obj1 = new Example1();
    obj1.printData(); // will print 100
}
}