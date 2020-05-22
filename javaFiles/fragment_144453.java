@Override
public void validate(Object target, Errors errors) {
Test test = (Test) target;
String testTitle = test.getTestTitle();

//**ErrorCheck1** - This works, and I am able to pull the value in my controller
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testTitle", "test.testTitle.projec", "My msg");


if (testTitle != null && testTitle.length() < 4) {
    logger.error("Inside custom validation"+test.testTitle().length());

    //**Error Check2**
    //***HOW DO I RETRIEVE THE BELOW VALUE in My controller
    errors.reject(testTitle, "test.testTitle.lessThen4");
    errors.addAllErrors(errors);
    logger.error("Entered If condition of validate");
   }
}