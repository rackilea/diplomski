public abstract class ParentValidator
    {
        private final ValidatorStrategy validator;

        protected ParentValidator(ValidatorStrategy validator){
           this.validator = validator;
        }

        public final void validate() {
            //some code
            this.validator.validate();
        }
    }