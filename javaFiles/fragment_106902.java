public class MyExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context)  {
        context.getTestInstance().ifPresent(testInstance -> {
            List<Field> driverFields = AnnotationSupport.findAnnotatedFields(testInstance.getClass(), MyDriver.class);
            for (Field driverField : driverFields) {
                try {
                    Object fieldValue = driverField.get(testInstance);
                    // Do whatever you want with the field or its value
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}