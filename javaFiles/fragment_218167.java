public final class ParseUtil {

    public interface IStringParser<E> {
        public E parse(String s) throws ParseException;
    }

    private ParseUtil() {}

    private static Map<Class<?>, IStringParser<?>> STRING_PARSERS = new ConcurrentHashMap<>();

    public static <E> void registerStringParser(Class<E> c, IStringParser<E> p){
        STRING_PARSERS.put(c, p);
    }

    @SuppressWarnings("unchecked")
    public static <E> IStringParser<E> getStringParser(Class<E> c){
        return (IStringParser<E>) STRING_PARSERS.get(c);
    }

    public static <E> E parse(String s, Class<E> clazz) throws ParseException{
        if (s == null || s.length() == 0 || clazz == null) {
            throw new IllegalArgumentException();
        }

        IStringParser<E> stringParser = getStringParser(clazz);
        if (stringParser == null) {
            throw new ParseException(clazz);
        }
        return stringParser.parse(s);
    }
}