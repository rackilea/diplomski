public class Lowerclass extends Upperclass {
    public Lowerclass() {
        if (ok == true) {
            number = number * 3;
        }
        System.out.print(number + " " ); //first output of 18
    }
    public void doSomething() {
        if (ok == false) {
            number = number * 3;
        }
        System.out.print (number); // second output of 18
    }
}

public class Test {
    public static void main (String[] args) {
        Lowerclass lc = new Lowerclass(); // first output of 18 in constructor 
        lc.doSomething(); // second output in the method 
        System.out.println();
    }
}