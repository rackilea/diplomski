class Example3 {
    static int a = 300;

    public static void printData() {
        getData(); // accessing class method
    }

    public static void getData() {

        System.out.println(a); // accessing class variable 'a'
    }

}

public class InstanceDemo {

public static void main(String[] args) {

    //calling class method : class method are called using class name. 
    Example3.printData(); // will print 300
}

}