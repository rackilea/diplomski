public class FieldComparator<T> implements Comparator<T> {
    private static final Logger LOG = Logger.getLogger(
            FieldComparator.class.getName());
    private static final AlphanumComparator ALPHANUM = new AlphanumComparator();

    private final Field field;
    private final boolean isString;
    private final boolean isComparable;

    public FieldComparator(Class<T> clazz, String name) {
        try {
            field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            isString = fieldType == String.class;
            isComparable = Comparable.class.isAssignableFrom(fieldType);
        } catch (NoSuchFieldException | SecurityException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public int compare(T o1, T o2) {
        try {
            Object value1 = field.get(o1);
            Object value2 = field.get(o2);
            if (value1 == null) {
                return value2 == null ? 0 : -1;
            } else if (value2 == null) {
                return 1;
            } else if (isString) {
                return ALPHANUM.compare((String)value1, (String)value2);
            } else if (isComparable) {
                return ((Comparable)value1).compareTo(value2);
            } else {
                // don't know how to compare fields
                return 0;
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }
}