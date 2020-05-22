private static void printLoToHi(int n){
        if(n<1){          // This is the base case that terminates the recursion.
            return;       // You'll always have one - sometimes more.
        }
        printLoToHi(n-1); // This is where the recursion takes place.
        printMany(n);     // But when n < 1 it returns to here and continues on.
}