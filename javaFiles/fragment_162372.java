public static void main(String[] args) throws Exception {
    final int LENGTH = Integer.MAX_VALUE / 256;
    Object[] values = new Object[LENGTH];
    int count = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
        Object o = new Object();
        int hashCode = o.hashCode();
        if (hashCode > LENGTH)
            continue;
        if (values[hashCode] != null) {
            System.out.println("found after " + count + ": " + values[hashCode] + " same hashcode as " + o);
            System.out.println(values[hashCode] == o);
            System.exit(0);
        } else {
            System.out.println(hashCode);
            values[hashCode] = o;
            count++;
        }
    }
}