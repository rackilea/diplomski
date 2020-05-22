public static void main(String[] args) {
     int apa[] = {3,3,3};
     System.out.print(allEqual(apa));

 }
 public static boolean allEqual(int[] a) {
    int summa = 0;
    boolean svar = true;
    for (int i = 0; i < a.length; i++) { // <-- HERE
// if i == a.length, an ArrayIndexOutOfBoundsException will be raised
        summa +=a[i];

    }
    if (summa % a.length == 0) {
        return svar;
    } else {
        svar = false;
        return svar;
    }

}