public class Tester {
    public static void main(String [] args) {
        // create two objects of ComplexNumbers with whatever values you like
        ComplexNumber numA = new ComplexNumber(....);
        ComplexNumber numB = new ComplexNumber(....);

        // then add them and store the returned reference into a new variable
        ComplexNumber result = numA.plus(numB);
        // print the number however you like
        System.out.println(result.real + " + i" + result.getImag());

    }

}