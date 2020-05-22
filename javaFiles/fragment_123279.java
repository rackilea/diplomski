for (o = 0; o < month.length; o++) {

    if (tempChoice.equalsIgnoreCase("C")) {
        System.out.printf("%n");
        System.out.printf(month[o]);
        System.out.printf("%20.2f", celsius[o]);
        System.out.printf("%25.2f", precipitation[o]);
    }

}