class Argument<E>  {
    E realArgument;
    Validator validator;
    public Argument(E value, Validator validator) {
        //implement
    }

}
interface Validator {
    public void validate() throws BaseValidationException;
}