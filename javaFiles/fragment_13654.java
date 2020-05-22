public class Main {

    public static void main(String[] args) {

        //Set class1Num1
        Class1 instance1 = new Class1();
        instance1.setClass1Num1(1);

        //Set class2Num1
        Class2 instance2 = new Class2();
        instance2.setClass2Num1(1);

        //add class1Num1 + class2Num1
        int sum = instance1.getClass1Num1() + instance2.getClass2Num1();

        //Set sum into class1Num1 of instance1
        instance1.setClass1Num1(sum);

        //Printing class1Num1 (2)
        System.out.println(instance1.getClass1Num1());

    }
}