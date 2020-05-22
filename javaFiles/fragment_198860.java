for (int counter = 2; counter <= Math.sqrt(Number); counter++) {
    while (Number % counter == 0) {
        Number /= counter;
        System.out.print(" " + counter);
    }
}
// Print what's left.
if (Number > 1) {
   System.out.println(" " + Number);
}