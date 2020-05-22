import java.util.InputMismatchException; //added the import
import java.util.Scanner; // added the import

class NumberHighException extends Exception {
    public NumberHighException() {}
    public NumberHighException(String str) {
        super(str);
    }
    public String toString() {
        return "NumberHighException";
    }
}

class NumberLowException extends Exception {
    public NumberLowException() {}
    public NumberLowException(String str) {
        super(str);
    }
    public String toString() {
        return "NumberLowException";
    }
}

// negative number is a type of low number 
class NumberNegativeException extends NumberLowException {

    public NumberNegativeException() {}
    public NumberNegativeException(String str) {
        super(str);
    }
    public String toString() {
        return "NumberNegativeException";
    }
}

class Verify {
    // lowest number in range    
    private int minimum;
    // highest number in range    
    private int maximum;
    // constructor sets minimum and maximum values in range    
    public Verify(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
    // validate that number is within range    
    public void validate(int number)
    throws NumberNegativeException, NumberLowException, NumberHighException

    {
        if (number < 0) throw new NumberNegativeException("number < 0");
        else if (number < minimum) throw new NumberLowException("number < 10");
        else if (number > maximum) throw new NumberHighException("number > 100");
    }
}

public class Program5 // added the public keyword
{
    public static void main(String[] args) {
        int number = 0;
        int returnCode = 0;
        int minimum = 10;
        int maximum = 100;

        // create object to verify number is within range 10 to 100       
        Verify ok = new Verify(minimum, maximum);

        // create Scanner object to read keyboard       
        Scanner input = new Scanner(System. in );
        // prompt for input       
        System.out.print("Enter number between " + minimum +
            " and " + maximum + ": ");

        try {
            // read int from keyboard          
            // throws exception if non digits are entered          
            number = input.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("You entered a non digit");
            System.exit(1);
        }

        // validate that entered number is within specified range              
        try {
            ok.validate(number);
        } catch (NumberHighException e) {
            System.out.println("NumberHighException: " + e.getMessage());
            returnCode = 2;
        }

        // because NumberNegativeException is subclass of NumberLowException       
        // it must be caught before NumberLowException or compile error results       
        catch (NumberNegativeException e) {
            System.out.println("NumberNegativeException: " + e.getMessage());
            returnCode = 3;
        } catch (NumberLowException e) {
            System.out.println("NumberLowException: " + e.getMessage());
            returnCode = 4;
        } finally {
            // true is number entered was within range          
            if (returnCode == 0) System.out.println(number + " is valid number");
        }
        System.exit(returnCode);
    }
}