// search all the powers of 2 until  (x + 1) - x != 1
for (long l = 1; l > 0; l <<= 1) {
    double d0 = l;
    double d1 = l + 1;
    if (d1 - d0 != 1) {
        System.out.println("Cannot represent " + (l + 1) + " was " + d1);
        break;
    }
}