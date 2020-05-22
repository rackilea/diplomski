public static void main(String[] args) throws Exception {

    int[] arrayInts;
    int[] originalInts = { 1, 2, 3, 4, 5 };

    arrayInts = new int[originalInts.length];

    for(int i = 0; i < originalInts.length; i++){
        arrayInts[i] = originalInts[i];
    }

    originalInts[0] = 10;
    for (int i : arrayInts) {
        System.out.println(i);
    }
}