public final class CheckingFunctions {
    public interface ICheckingFunctions<T extends People> {
        boolean checkName(T p);    
        boolean checkAge(T p);
    }

    private static Map<Class<?>,ICheckingFunctions<?>> checkFunctions = new ConcurrentHashMap<>();

    public static <T extends People> void registerCheckFunction(ICheckingFunctions<T> checkFunction, Class<T> c) {
        checkFunctions.put(c, checkFunction);
    }

    private static <T extends People> ICheckingFunctions<T> getRegisteredCheckFunction(Class<T> c){
        ICheckingFunctions<T> checkFunction = (ICheckingFunctions<T>) checkFunctions.get(c);
        if (checkFunction == null) {
            // provide some reasonable default?
            throw new IllegalStateException();
        }
        return checkFunction;
    }

    public static <T extends People> boolean checkName(T ppl, Class<T> c){
        return getRegisteredCheckFunction(c).checkName(ppl);
    }

    public static <T extends People> boolean checkAge(T ppl, Class<T> c){
        return getRegisteredCheckFunction(c).checkAge(ppl);
    }
}