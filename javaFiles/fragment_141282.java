enum Mask {
    W(new int[] { 1, 1 });
    private final int[] myArray;

    private Mask(int[] myArray) {
        this.myArray = myArray;
    }

}