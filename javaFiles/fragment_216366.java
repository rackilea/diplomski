char oth = (a == 'x') ? 'o' : 'x';
for (int i = 0; i < (b * b); i++) {
    System.out.print(i % 2 == 0 ? a : oth);
    if ((i + 1) % b == 0) {
        System.out.println();
    }
}