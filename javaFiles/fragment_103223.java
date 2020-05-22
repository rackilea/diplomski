public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        int[] ints = new RandomClass().generateRandomArray(10);
        System.out.println("RandomClass::main: ints = " + Arrays.toString(ints));
    }
}