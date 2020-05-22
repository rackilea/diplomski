import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class LegacyObjectHandler implements InvocationHandler {
    private static final Logger LOG = Logger.getLogger(LegacyObjectHandler.class);

    private final List<String> unsupportedFields = new ArrayList<>();

    private final LegacyObject legacyObject;

    public LegacyObjectHandler(LegacyObject legacyObject) {
        this.legacyObject = legacyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getUnsupportedFields".equals(method.getName())) {
            return unsupportedFields;
        } else {
            try {
                return method.invoke(legacyObject, args);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                LOG.error(cause.getMessage(), cause);
                unsupportedFields.add(method.getName());
                Class<?> returnType = method.getReturnType();
                if (returnType.isPrimitive()) {
                    if (returnType.isAssignableFrom(boolean.class)) {
                        return false;
                    } else if (returnType.isAssignableFrom(byte.class)) {
                        return (byte) 0;
                    } else if (returnType.isAssignableFrom(short.class)) {
                        return (short) 0;
                    } else if (returnType.isAssignableFrom(int.class)) {
                        return 0;
                    } else if (returnType.isAssignableFrom(long.class)) {
                        return 0L;
                    } else if (returnType.isAssignableFrom(float.class)) {
                        return 0F;
                    } else if (returnType.isAssignableFrom(double.class)) {
                        return 0D;
                    } else if (returnType.isAssignableFrom(char.class)) {
                        return (char) 0;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
    }
}