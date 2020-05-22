//PSEUDOCODE WATCH YOURSELF

private static int findGCD(int n1, int n2) {
    int result = 0;
    while(true) {
        if(n2 == 0) {
            return result;
        }
        result = n1;
        n1 = n2;
        n2 = result-n2;
    }
}