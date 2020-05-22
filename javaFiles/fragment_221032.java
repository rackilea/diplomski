package ooexample;

    public class OOExample {

    public static void main(String[] args) {
        int min = 2;
        int max = 101;

        // use of static method
        int randomNumberA = MyMath.generateRandomNumber(min, max);

        // use of non static method
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int randomNumberB = generator.randomNumber(min, max);

        /**
        * does not work, method is private, can not be accessed from an outise class
        * only RandomNumberGenerator can access it
        */        
        // generator.printSomeNumber(123);
    }
}