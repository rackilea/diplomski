public interface AddressValidator {
    static class AddressValidatorResult {
        // some results, you might want to return some useful feedback (if not valid)

        boolean isValid() {
            throw new IllegalStateException("Method not implemented yet");
        }
    }

    public static class AddressValidationException extends Exception {
        private AddressValidationException(AddressValidatorResult result) {
            // add some implementation
        }
    }


    // don't throw ValidateException here, invalid addresses are normal for
    // validators, even if they aren't for the application that uses them
    AddressValidatorResult validateAddress(String address);
        // don't throw ValidateException here, invalid addresses are normal for
        // validators, even if they aren't for the application that uses them
}

public class DefaultAddressValidator implements AddressValidator {

    public static class Params {
        // some parameters for this specific validator
    }

    private final Params params;

    public DefaultAddressValidator(Params params) {
        // creates this validator
        this.params = params;
    }

    @Override
    public AddressValidatorResult validateAddress(String address) {
        // perform your code here

        // I don't like "return null" as it may lead to bugs
        throw new IllegalStateException("Method not implemented yet");
    }
}


// and use it like this
private void validateAddress(String address) throws AddressValidationException {
    // e.g. field AddressValidator set in constructor 
    AddressValidatorResult result = addressValidator.validateAddress(address);
    if (!result.isValid()) {
        throw new AddressValidationException(result);
    }
}