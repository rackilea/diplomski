static AtomicInteger ai = new AtomicInteger();
static int generate() {
    return ai.incrementAndGet();
}

public static void main(String[] args) {

    int[] result = new int[10];
    Arrays.fill(result, generate());
    System.out.println(Arrays.toString(result));

    Arrays.setAll(result, i->generate());
    System.out.println(Arrays.toString(result));

}