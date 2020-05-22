int a = 1;
int b = 0;

while (a < 5) {
    System.out.println("Outer loop: a="+a+", b="+b);
    while (b < a) {
        System.out.println("Inner loop: a="+a+", b="+b);
        b++;
    }

    System.out.println();
    a++;
}