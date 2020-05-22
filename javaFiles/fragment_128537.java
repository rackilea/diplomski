public class Main {
    //This is to simulate instances which are not equal but go to the same bucket.
    static class A {
            @Override
            public boolean equals(Object obj) { return false;}

            @Override
            public int hashCode() {return 42; }
        }

    public static void main(String[] args) {
            //Test data  
            HashMap<A, String> map = new HashMap<A, String>(4);
            map.put(new A(), "abc");
            map.put(new A(), "def");

            //Access to the internal table  
            Class clazz = map.getClass();
            Field table = clazz.getDeclaredField("table");
            table.setAccessible(true);
            Map.Entry<Integer, String>[] realTable = (Map.Entry<Integer, String>[]) table.get(map);

            //Iterate and do pretty printing
            for (int i = 0; i < realTable.length; i++) {
                System.out.println(String.format("Bucket : %d, Entry: %s", i, bucketToString(realTable[i])));
            }
    }

    private static String bucketToString(Map.Entry<Integer, String> entry) throws Exception {
            if (entry == null) return null;
            StringBuilder sb = new StringBuilder();

            //Access to the "next" filed of HashMap$Node
            Class clazz = entry.getClass();
            Field next = clazz.getDeclaredField("next");
            next.setAccessible(true); 

            //going through the bucket
            while (entry != null) {
                sb.append(entry);
                entry = (Map.Entry<Integer, String>) next.get(entry);
                if (null != entry) sb.append(" -> ");
            }
            return sb.toString();
        }
}