import io.shido.domain.Envelope;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.Map;

public final class Factory<T extends Envelope> {
  private final Class<T> clazz;

  private final Map<String, Object> regularMembers;

  private final Map<String, Object> secureMembers;

  public Factory(final Class<T> clazz, final Map<String, Object> regularMembers, final Map<String, Object> secureMembers) {
    this.clazz = clazz;
    this.regularMembers = regularMembers;
    this.secureMembers = secureMembers;
  }

  public T build() {
    try {
      final T result = clazz.newInstance();
      regularMembers.forEach((fieldName, fieldValue) -> assign(result, fieldName, fieldValue));
      secureMembers.forEach((fieldName, fieldValue) -> assign(result, fieldName, fieldValue));
      return result;
    } catch (final Exception e) {
      logger.error("Cannot build type based on input parameters due to:", e);
      throw new IllegalStateException(e.toString());
    }
  }

  private void assign(final T type, final String fieldName, final Object fieldValue) {
    try {
      FieldUtils.getField(type.getClass(), fieldName).set(type, fieldValue);
    } catch (final IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}