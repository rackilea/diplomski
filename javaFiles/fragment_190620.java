class Example2 {
    static int a = 20; // 'static' / class variable

    public void printData() { // instance method
        setData(); // accessing class method directly
        System.out.println(a); // accessing class variable directly
    }

    public static void setData() { // class method 'static'

        a = 200; // setting value of class variable 'a'
    }

    }


public class InstanceDemo {

public static void main(String[] args) {

    Example2 obj2 = new Example2();
    obj2.printData(); // will print 200
}   
}