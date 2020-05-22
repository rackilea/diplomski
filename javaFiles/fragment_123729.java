boolean a = true;
    boolean b = false;
    boolean c = false;
    boolean d = false;

    if ((a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0) == 1) {
        System.out.println("You win!");
    }