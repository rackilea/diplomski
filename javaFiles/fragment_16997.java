public class myAnnotation_Validator implements ConstraintValidator<myAnnotation, Collection> {
     private String[] names;

     @Override
     public void initialize(myAnnotation a) {
        //get values which are defined in the annotation
        names = myAnnotation.namen();
     } 

     @Override
     public boolean isValid(Collection objectToValidate, ConstraintValidatorContext cvc) {

        if(objectToValidate == null) return true; // use the @NotNull annotation for null checks 

        for(Object o : objectToValidate) {
           //check if value is valid
        }

        return false; 
    } 
}