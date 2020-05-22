public class Main {

    private static final Map<Class, Field> cache = new HashMap<>();

    public static void main(String[] args) {
        SomeClass x = new SomeClass(12345);
        //Testing speed
        System.out.println("Test 1");
        int repeats = 10000000;
        long count = 0;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < repeats; i++) {
            setField(x, i);
            if (x.getNumStairs() == i) {
                count++;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("\tCount = " + count);
        System.out.println("\tTime = " + (t2 - t1));
        System.out.println("Test 2");
        count = 0;
        t1 = System.currentTimeMillis();
        for (int i = 0; i < repeats; i++) {
            setField2(x, i);
            if (x.getNumStairs() == i) {
                count++;
            }
        }
        t2 = System.currentTimeMillis();
        System.out.println("\tCount = " + count);
        System.out.println("\tTime = " + (t2 - t1));
    }

    public static void setField(Object o, Integer value) {
        try {
            Field f = o.getClass().getDeclaredField("numStairs");
            f.setAccessible(true);
            f.set(o, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setField2(Object o, Integer value) {
        try {
            Field f = cache.get(o.getClass());
            if (f == null) {
                f = o.getClass().getDeclaredField("numStairs");
                f.setAccessible(true);
                cache.put(o.getClass(), f);
            }
            f.set(o, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}