import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

/* ... snip ... */

//get validator factory using default bootstrap mechanism of the Validation library
ValidatorFactory factory = Validation.byDefaultProvider().configure().buildValidatorFactory();

//get a validator instance
Validator validator = factory.getValidator();

//create new object
Person person = new Person();
person.setFirstName("Andrew");

//validate person object
Set<ConstraintViolation<Person>> violations = validator.validate(person);

//should be one violation from lastName being null
assert violations.size() == 1;