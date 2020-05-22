public class Test {
    private static HashSet<Class<?>> classes = new HashSet<>();

    static {
        classes.add(String.class);
        classes.add(Integer.class);
        classes.add(GregorianCalendar.class);
    }

    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        X obj = new X();
        obj.setField("lala");
        Method method = obj.getClass().getMethod("getField", null);
        System.out.println(method.invoke(obj, null));

        Method setMethod = getWorkingMethod(obj);
        setMethod.invoke(obj, "who let the dogs out");
        System.out.println(obj.getField());
    }

    private static Method getWorkingMethod(Object obj) {
        Method method = null;
        for (Class<?> c : classes) {
            try {
                method = obj.getClass().getMethod("setField", c);
            } catch (NoSuchMethodException | SecurityException e) {
                continue;
            }
            if(method != null){
                return method;
            }
        }

        throw new IllegalArgumentException("No such method found!");
    }
}

class X {
    private String stringField;

    public void setField(String s) {
        stringField = s;
    }

    public String getField() {
        return stringField;
    }
}