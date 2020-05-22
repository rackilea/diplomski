class Foo {
    public static IntQueue[] buckets = new IntQueue[10];
    public static void radixj() {
        for (int i = 0; i < 10; i++) {
            Foo.buckets[i] = new IntQueue();
        }
    }

    public static void place(int temp, int marker) {
        int pos = temp % marker;
        Foo.buckets[pos].put(temp);
    }
}