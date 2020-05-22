public static void f(int x, int[] y, int[] z) {
    x = 2;
    y[0] = x;
    // Till here z is referring to the int array passed from main method
    z = new int[5]; // now z is re-assigned with a new reference, the one of the newly created int array
    // thus the reference to the original array is no more being used here
    z[0] = 555; // this modifies the values of the newly created array 
}