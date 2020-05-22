import org.apache.commons.validator.routines.EmailValidator;

public class Main {

    public static void main(String[] args) {

        EmailValidator validator = EmailValidator.getInstance();

        if (validator.isValid("john@newman.COM")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}