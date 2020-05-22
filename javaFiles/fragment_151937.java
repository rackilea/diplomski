public class Driver {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName(null);

      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      Set<ConstraintViolation<Person>> constraints = factory.getValidator().validate(p);
        // constraint will have the results of validation

    }
}