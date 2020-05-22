List<FieldError> errors = bindingResult.getFieldErrors();
for (FieldError error : errors ) {
    System.out.println ("Validation error in field: " + error.getField() 
                    + "! Validation error message: " + error.getDefaultMessage() 
                    + "! Rejected value:" + error.getRejectedValue());
}