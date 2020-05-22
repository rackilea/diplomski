public static void main(String[] args) {
    String[][] array2d = createArray();

    CharSequence charSequnce = new Array2DColumnCharSequnce(array2d, 0);

    boolean contentEquals = "Next Next ".contentEquals(charSequnce);
    System.out.println(contentEquals);

    CharSequence column1CharSequnce = new Array2DColumnCharSequnce(array2d, 1);
    String replaced = "I want to say Next Next ".replace(charSequnce, column1CharSequnce);
    System.out.println(replaced);
}