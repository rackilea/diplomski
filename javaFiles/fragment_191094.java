int k = 0;
    do {
        k = input.nextInt();
        if (k == 1) {
            System.out.println("Storsta talet är: " + max);
        } else if (k == 2) {
            System.out.println("Minsta talet är: " + min);
        } else if (k == 3) {
            System.out.println("Medeltalet är: " + sum / 10);
        } else if (k == 4) {
            System.out.println("Alla tal: " + num[10] + ", ");
        } else if (k == 5) {
            System.out.println("Hej då!");//good bye
            break;
        } else {
            System.out.println("Felaktigt, prova igen.");
        }
    } while (k < 5) ;