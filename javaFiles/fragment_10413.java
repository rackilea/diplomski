public class Dog {

     static final int val1 = -5;// This is final, so will be initialized at compile time 
     static int val2 = 3;
     public int val3;

     public static Dog dog = new Dog();//move to here

     public Dog() {
          val3 = val1 + val2;
     }

    public static void main(String[] args) {
        System.out.println(Dog.dog.val3);//output will be -2
    }
}