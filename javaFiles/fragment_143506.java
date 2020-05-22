public class ClassA {

    public static void main(String[] args) {

        ClassB obj = new ClassB();
        ArrayList aa = new ArrayList();

        aa.add(obj.age); // int
        aa.add(obj.name); // string

        aa.add(15.2); // float
    }

}