package test;

public class Demo {

    public Demo() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("test.Demo");
        Demo demo = (Demo) clazz.newInstance();
    }
}