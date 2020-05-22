import org.springframework.validation.annotation.Validated;

@Validated
public class Validator {

    public void validateA(@Valid A a) {
        // nothing here
    }
}