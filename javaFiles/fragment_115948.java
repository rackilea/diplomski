private static void generateSequence(int num) {
    System.out.println(num);

    if(num == 1) return;  /* Add a base case */

    if(num % 2 == 0) {
        generateSequence(num/2);
    } else {
        generateSequence(num*3+1);
    }
}