if (Year <= 1582) {
    System.out.println("The entered year is prior to the Gregorian Callandar");
} else if ((Year % 4) == 0) {
    if (((Year % 400) + (Year % 100)) == 0) {
        System.out.println("The entered year is a leapyear");
    } else {
        System.out.println("The Entered year is not a leapyear");
    }
} // else?