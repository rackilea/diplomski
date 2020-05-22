ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
Validator validator = validatorFactory.getValidator();

String question = jComboBox.getSelectedItem().toString();
MyModel model = new MyModel();
model.setQuestion(model);

Set<ConstraintViolation<MyModel>> constraintViolations = validator.validate(model);

if (!constraintViolations.isEmpty()) {
        String error = "";
        for (ConstraintViolation<MyModel> constraintViolation : constraintViolations) {
                error += constraintViolation.getMessage();
                JOptionPane.showMessageDialog(null, error);
        }
}