import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public class ObjectUtils {

  /**
   * Tests an object for logical emptiness. An object is considered logically empty if its public gettable property
   * values are all either null, empty Strings or Strings with just whitespace, or lists that are either empty or
   * contain only other logically empty objects.  Currently does not handle Maps or Arrays, just Lists.
   * 
   * @param object
   *          the Object to test
   * @return whether object is logically empty
   * 
   * @author Kevin Pauli
   */
  @SuppressWarnings("unchecked")
  public static boolean isObjectEmpty(Object object) {

    // null
    if (object == null) {
      return true;
    }

    // String
    else if (object instanceof String) {
      return StringUtils.isEmpty(StringUtils.trim((String) object));
    }

    // List
    else if (object instanceof List) {
      boolean allEntriesStillEmpty = true;
      final Iterator<Object> iter = ((List) object).iterator();
      while (allEntriesStillEmpty && iter.hasNext()) {
        final Object listEntry = iter.next();
        allEntriesStillEmpty = isObjectEmpty(listEntry);
      }
      return allEntriesStillEmpty;
    }

    // arbitrary Object
    else {
      try {
        boolean allPropertiesStillEmpty = true;
        final Map<String, Object> properties = PropertyUtils.describe(object);
        final Iterator<Entry<String, Object>> iter = properties.entrySet().iterator();
        while (allPropertiesStillEmpty && iter.hasNext()) {
          final Entry<String, Object> entry = iter.next();
          final String key = entry.getKey();
          final Object value = entry.getValue();

          // ignore the getClass() property
          if ("class".equals(key))
            continue;

          allPropertiesStillEmpty = isObjectEmpty(value);
        }
        return allPropertiesStillEmpty;
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
      } catch (NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
    }
  }

}