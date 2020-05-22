@Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    return disableRequiredOnParameterizedTests(context);
  }

private ConditionEvaluationResult disableRequiredOnParameterizedTests(ExtensionContext context) {
    // See if my custom annotation is present on the test
    var onParameters = findRepeatableAnnotation(context, DisableOnParameter.class);
    // Or if the test is a Parameterized test after all
    // We have access to arguments when the test will be at method level, i.e. MethodExtensionContext
    if (!MethodExtensionContext.class.isAssignableFrom(context.getClass())
        || findAnnotations(context, ParameterizedTest.class).isEmpty()
        || onParameters.isEmpty()) {
      return enabled("Not set to disable");
    }
    List<Object> arguments = getArguments(context);
    boolean enable = true;
    // Do what you want with arguments
    .
    .
    .
    return enable ? enabled("Enabling") ? disabled("Disabling");
  }

/**
   * A blanket exception safe function to extract arguments from Extension context using
   * reflection since we don't have direct access to the API
   * https://github.com/junit-team/junit5/issues/1139
   *
   * @param context needs to be of {@link MethodExtensionContext} type since only at that stage
   *     arguments can be extracted
   * @return List of argument objects, empty if any error occurs
   */
  private static List<Object> getArguments(ExtensionContext context) {
    try {
      if(MethodExtensionContext.class.isAssignableFrom(context.getClass())) {
        return emptyList();
      }
      Method method = findMethod(context.getClass(), "getTestDescriptor").orElseThrow();
      TestMethodTestDescriptor descriptor =
          (TestMethodTestDescriptor) invokeMethod(method, context);

      // Get the TestTemplateInvocationContext
      Field templateField = descriptor.getClass().getDeclaredField("invocationContext");
      templateField.setAccessible(true);
      TestTemplateInvocationContext template =
          (TestTemplateInvocationContext) templateField.get(descriptor);

      // Get the params finally
      Field argumentsField = template.getClass().getDeclaredField("arguments");
      argumentsField.setAccessible(true);
      return asList((Object[]) argumentsField.get(template));
    } catch (Throwable ignored) {
      return emptyList();
    }
  }