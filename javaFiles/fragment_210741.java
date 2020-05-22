import java.util.*;

interface PaymentValidatorInterface {
    public boolean validate(PaymentValidationContext context);
}

class PaymentValidationContext {
    String result = "";
    String user;
    int cardData;
    String merchant;

    public PaymentValidationContext(String user, int cardData) {
        this.user = user;
        this.cardData = cardData;
    }
}

class PaymentValidator {
    public static boolean validateUser(PaymentValidationContext context) {
        if (context.user == null) {
            context.result += "User is wrong\n";
            return false;
        }
        return true;
    }

    public static boolean validateMerchant(PaymentValidationContext context) {
        context.merchant = context.user + "#" + context.cardData;
        if (context.merchant.length() <= 3) {
            context.result += "Marchant is wrong\n";
            return false;
        }
        return true;
    }

    public static boolean finishValidation(PaymentValidationContext context) {
        context.result += "Everything is fine.\n";
        return true;
    }
}

public class Processor {
    private final static Queue<PaymentValidatorInterface> validators = new LinkedList<>();
    static {
        validators.add(PaymentValidator::validateUser);
        validators.add(PaymentValidator::validateMerchant);
        validators.add(PaymentValidator::finishValidation);
    }

    public String processPayment(String user, int cardData) {
        PaymentValidationContext context = new PaymentValidationContext(user, cardData);
        validators.stream().anyMatch(validator -> !validator.validate(context));
        return context.result;
    }

    // For testing -------
    public static void main(String[] args) {
        Processor p = new Processor();
        System.out.print(p.processPayment("Foobar", 1337));    // ok
        System.out.print(p.processPayment(null, 1337));        // fails
        System.out.print(p.processPayment("", 1));             // fails
    }
}