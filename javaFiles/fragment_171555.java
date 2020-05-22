Random rnd = new Random();
for (int i = 0; i < 5000; i++) {

    int rndInt = rnd.nextInt(25);

    for (int j = 0; j < rndInt; j++) {
        System.out.print(" * ");

    }
    System.out.println();  // newline

}