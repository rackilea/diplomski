SchematronOutputType schematronOutputType = schematronResourcePure.applySchematronValidationToSVRL(streamSource);
List<Object> failedAsserts = schematronOutputType.getActivePatternAndFiredRuleAndFailedAssert();
for (Object object : failedAsserts) {
    if (object instanceof FailedAssert) {
        FailedAssert failedAssert = (FailedAssert) object;
        System.out.println(failedAssert.getText());
        System.out.println(failedAssert.getTest());
    }
}