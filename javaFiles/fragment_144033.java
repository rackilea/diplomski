import java.util.Random;

class ClassA {
    public static void main(String args[]){
        Random randomVariable = new Random();
        int a,b,c;

        //initially generate your random variables
        a = randomVariable.nextInt(10);
        b = randomVariable.nextInt(10);
        c = a + b;

        //check if the condition is met
        while(a + b + c != 30) {
           //if not, regenerate the numbers
           a = randomVariable.nextInt(10);
           b = randomVariable.nextInt(10);
           c = a + b;
        }

        if(c==10) {
            System.out.println("Whatever you want");
        }
    }
}