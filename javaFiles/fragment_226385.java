import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;

public class User {

    @NotNull(message = "username cannot be null")
    @Size(min = 2, max = 15)
    private String username;

    @Max(100)
    private int age;

    @Email
    private String email;

    @CreditCardNumber
    private String creditCardNumber;

    // constructors, getters, setters
}