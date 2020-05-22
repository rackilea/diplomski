@Retention(RetentionPolicy.RUNTIME)
public @interface Field1 {}

@Retention(RetentionPolicy.RUNTIME)
public @interface Field2 {}

public static class UnderTest {

    @Field1
    private String field1;

    @Field2
    private int field2;

    public UnderTest(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return field1 + "=" + field2;
    }
}

public static void setter(Object obj, Class<? extends Annotation> fieldAnnotation, Object fieldValue) throws IllegalAccessException {
    for (Field field: obj.getClass().getDeclaredFields()) {
        for (Annotation annot: field.getDeclaredAnnotations()) {
            if (annot.annotationType().isAssignableFrom(fieldAnnotation)) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(obj, fieldValue);
            }
        }
    }
}

public static void main(String[] argv) throws IllegalAccessException {
    UnderTest underTest = new UnderTest("A", 1);
    System.out.println(underTest);

    setter(underTest, Field1.class, "B");
    setter(underTest, Field2.class, 2);
    System.out.println(underTest);
}