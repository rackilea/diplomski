int from = 10;
int to = 99;
for (int i = from; i <= to; i++) {
    for (int j = from ; j <= to; j++) {
        int mult = i*j;
        if (isPalindrome(mult))
            System.out.println(i + "x" + j + "=" + mult + " is plaindrome!");
    }
}