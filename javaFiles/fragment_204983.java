public class CompareEverything {

    public static void sort(List someList, int columnNumber) {
        Collections.sort(someList, new EverythingComparator(columnNumber));
    }

    public static class EverythingComparator implements Comparator<List<?>> {
        private int columnNumber;

        public EverythingComparator(int columnNumber) {
            this.columnNumber = columnNumber;
       }

        @Override
        public int compare(List<?> list1, List<?> list2) {
            Object obj1 = list1.get(columnNumber);
            Object obj2 = list2.get(columnNumber);
            return CompareEverything.compare(obj1, obj2);
       }
    }

    public static int compare(Object obj1, Object obj2) {
        int result = 0;
        if (obj1 == null) {
            result = (obj2 == null) ? 0 : -1;
        }
        else if (obj2 == null) {
            result = 1;
        }
        else if (obj1 instanceof CharSequence && obj2 instanceof CharSequence) {
            // String, StringBuilder, StringBuffer, etc.
            result = obj1.toString().compareTo(obj2.toString());
        }
        else if (obj1 instanceof Number && obj2 instanceof Number) {
            Number num1 = (Number)obj1;
            Number num2 = (Number)obj2;
            // Short, Integer, or Long
            if (isIntegral(obj1.getClass()) && isIntegral(obj2.getClass())) {
                result = Long.compare(num1.longValue(), num2.longValue());
            }
            else { // Float, Double, or any mismatched combo
                result = Double.compare(num1.doubleValue(), num2.doubleValue());
            }
        }
        // add other types...
        else {
            // mismatched types - compare as Strings
            // or maybe throw a RuntimeException?
           result = obj1.toString().compareTo(obj2.toString());
        }
        return result;
    }

    private static boolean isIntegral(Class<?> type) {
        return Short.class.equals(type) || Integer.class.equals(type) || Long.class.equals(type);
    }
}