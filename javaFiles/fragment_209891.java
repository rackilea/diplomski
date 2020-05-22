public static int sho(int curr, int max) {
    if (curr == max) {
        return curr;
    }
    else {
        return curr + sho(curr + 1, max);
    }
}

public static void main(String args[]) {
    System.out.println(sho(10, 15)); // 10 11 12 13 14 15
}