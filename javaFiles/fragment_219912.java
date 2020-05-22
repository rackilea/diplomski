public static void outputInReverse(String[] FirstOrder) {
    String[] FinalOrder = new String[] {"One", "Two", "Three"};

    int j = 0;
    for (int i = 2; i >= 0; i--) {
            FinalOrder[j] = FirstOrder[i];
            j++;
    }
    System.out.println(Arrays.toString(FinalOrder));
}