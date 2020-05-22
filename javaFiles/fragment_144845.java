public class Test {
    private static Object createInstance(String classPath) {
        try {
            Class<?> tClass = Class.forName(classPath);
            if (tClass != null) {
                return tClass.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public final static <INPUT, OUTPUT> Filter<INPUT, OUTPUT> getFilter(String path) {
        return (Filter<INPUT, OUTPUT>) createInstance(path);
    }

    public final static <INPUT, OUTPUT> OUTPUT filter(String path, INPUT mes) {
        Filter<INPUT, OUTPUT> filter = getFilter(path);
        return filter.filter(mes);
    }
}