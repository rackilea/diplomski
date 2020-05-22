public class Validator {
    private static Validator instance = null;

    /**
     * Do not use new Validator; use Validator.getInstance() instead.
     */
    private Validator() {
        // read in
    }

    public static Validator getInstance() {
        if(instance == null) {
            instance = new Validatorr();
        }
        return instance;
    }

    public boolean validate(String str) {
        // check and return
    }
}