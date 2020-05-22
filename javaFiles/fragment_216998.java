public class CustomCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalController.class.getName());
      String condition = (String) attributes.get("condition");
      return "GO".equalsIgnoreCase(condition);
    }

}