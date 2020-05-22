import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

    public class HibernaterTest {



        public static void main(String[] args) {

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

            MyModel m = new MyModel();
            m.test = null;

            Set<ConstraintViolation<MyModel>> validate = validator.validate(m);
            System.err.println(validate.size());

            m.test = "some string";

            validate = validator.validate(m);
            System.err.println(validate.size());
        }


        public static class MyModel {

            @NotNull
            String test;

        }
    }