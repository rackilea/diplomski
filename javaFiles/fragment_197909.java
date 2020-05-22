public class MyAnnotationTransformer implements IAnnotationTransformer {

    private static final String GIVEN = "given: ";
    private static final String WHEN = "when: ";
    private static final String THEN = "then: ";

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            String description = annotation.getDescription();
            if (description != null && !description.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String item : description.split("\\|")) {
                    if (item.startsWith(GIVEN)) {
                        sb.append("<b>Given</b> ").append(item.substring(GIVEN.length())).append("<br />");
                    } else if (item.startsWith(WHEN)) {
                        sb.append("<b>When</b> ").append(item.substring(WHEN.length())).append("<br />");
                    } else if (item.startsWith(THEN)) {
                        sb.append("<b>Then</b> ").append(item.substring(THEN.length())).append("<br />");
                    } else {
                        sb.append(item).append("<br />");
                    }
                }
                description = sb.toString();
                annotation.setDescription(description);
            }
        }
    }
}