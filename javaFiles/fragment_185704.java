public abstract class ValidatorDecorator implements Validator
        {
            private final Validator validator;

            protected ParentValidator(Validator validator){
               this.validator = validator;
            }

            public final void validate() {
                //some code
                super.validate(); //still forced to invoke super
                this.validator.validate();
            }
        }