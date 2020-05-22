class MyStorage<T> {
    private static final class Range implements Comparable<Range> {
        private int first;
        private int last;

        public Range(int first_, int last_) {
            first = first_;
            last = last_;
        }

        // This heavily relies on that the ranges don't overlap
        @Override public int compareTo(Range other) {
            if (last < other.first)
                return -1;
            if (first > other.last)
                return 1;
            return 0;
        }
    }

    private Map<Range, T> theMap = new TreeMap<Range, T>();

    public void put(String key, T obj) {
        String[] ranges = key.split(";");
        for (String range : ranges) {
            //System.out.println("Adding " + range);
            String[] bounds = range.split("-");
            //System.out.println("Bounds " + bounds.length);
            int first = Integer.parseInt(bounds[0]);
            if (bounds.length == 1)
                theMap.put(new Range(first, first), obj);
            else 
                theMap.put(new Range(first, Integer.parseInt(bounds[1])), obj);
        }
    }

    public T get(String key) {
        return get(Integer.parseInt(key));
    }

    public T get(int key) {
        return theMap.get(new Range(key, key));
    }
}

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        MyStorage<Integer> storage = new MyStorage<Integer>();
        storage.put("10;20-30", 123);
        storage.put("15;31-50", 456);

        System.out.println(storage.get("42"));
    }
}