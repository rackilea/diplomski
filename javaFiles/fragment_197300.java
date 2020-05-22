public static void main(String[] args) {
    int x = 3;
    addOneTo(x); // x is still 3
    x = addOneTo(x); x is now 4
}

static int addOneTo(int number) {
    return number + 1;
}