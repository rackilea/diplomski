public class ReflectivePropertyExtractor<T, P> implements PropertyExtractor<T, P> {

    String fieldName;

    public ReflectivePropertyExtractor(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public P getProperty(T obj) {
        try {
            Method m = B.class.getMethod(makeAccessorName());
            return (P) m.invoke(obj);
        } catch (InvocationTargetException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private String makeAccessorName() {
        return "get" + capitalize(fieldName);
    }

    private String capitalize(String s) {
        if ((s == null) || (s.length() == 0))
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}