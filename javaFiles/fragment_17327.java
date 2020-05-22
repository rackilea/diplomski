import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

public class CustomAnnotationNotRequired {
  public static boolean validateForNotRequirdField(Object objectToValidate)
      throws Exception {

    Field[] declaredFields = objectToValidate.getClass().getDeclaredFields();

    for (Field field : declaredFields) {

      Annotation annotation = field.getAnnotation(NotRequired.class);
      if (!isValueClass(field.getType())) {
        field.setAccessible(true);
        if (field.get(objectToValidate) != null) {
          // validate nested field
          validateForNotRequirdField(field.get(objectToValidate));
        }
        continue;
      }
      if (annotation != null) {

        NotRequired notRequired = (NotRequired) annotation;

        if (notRequired.value()) {
          field.setAccessible(true);
          // annotated field is having value
          if (field.get(objectToValidate) != null) {
            throw new Exception();
          }
        }
      }
    }
    return true;
  }

  private static boolean isValueClass(Class<?> fieldType) {
    // Add other class if needed.
    return fieldType.equals(String.class) || fieldType.equals(Integer.class)
           || fieldType.equals(Short.class) || fieldType.equals(Long.class)
           || fieldType.equals(BigDecimal.class)
           || fieldType.equals(Date.class);
  }
}