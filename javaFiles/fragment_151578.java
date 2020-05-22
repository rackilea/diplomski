int size = 12;
for (int i = 0; i < size; i++) {
    if (i == 0) {
    for (int j = size; j > i - 3; j--) {
        System.out.print(" ");
    }
    System.out.print("*");
    }
    System.out.println("");
    for (int j = size; j >= i; j--) {
    System.out.print(" ");
    }
    System.out.print("**");
    for (int j = 0; j <= i * 2; j++) {
    System.out.print(" ");
    }
    System.out.print("**");
}
System.out.println("");

for (int i = 0; i < (size * 2) + 6; i++) {
    if (i == 0) {
    System.out.print(" ");
    } else {
    System.out.print("*");
    }
}
System.out.println("");
for (int i = 0; i < (size * 2) + 8; i++) {
    if (i == 0) {
    System.out.print("");
    } else {
    System.out.print("*");
    }
}