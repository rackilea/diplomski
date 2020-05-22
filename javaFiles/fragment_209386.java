System.out.println();
System.out.println();
System.out.println();
System.out.println();
for (int i = 0; i <= 100; i++) {
    System.out.print(Ansi.cursorUp(5));

    int v = i;
    if (i % 3 == 0) v *= 100;
    if (i % 10 == 0) v *= 1000;
    if (i % 21 == 0) v *= 1000000;

    System.out.print(Ansi.cursorDown());
    System.out.print(Ansi.eraseLine());
    System.out.printf("\rone %s", v + 5);

    System.out.print(Ansi.cursorDown());
    System.out.print(Ansi.eraseLine());
    System.out.printf("\rtwo %s", v + 1);

    System.out.print(Ansi.cursorDown());
    System.out.print(Ansi.eraseLine());
    System.out.printf("\rthree %s", v + 9);

    System.out.print(Ansi.cursorDown());
    System.out.print(Ansi.eraseLine());
    System.out.printf("\rfour %s", v + 15);

    System.out.print(Ansi.cursorDown());
    System.out.printf("\r");

    Thread.sleep(500);
}