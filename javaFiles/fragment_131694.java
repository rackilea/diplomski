public class Something {
        public static final int SOMETHING_0 = 0;
        public static final int SOMETHING_1 = 1;
        public static final int SOMETHING_2 = 2;

    }

 String getNameByValue(int intValue) throws IllegalArgumentException,
        IllegalAccessException {
    for (Field field : Something.class.getFields()) {
        if (field.getInt(null) == intValue) {
            return field.getName();
        }
    }
    return "";
}