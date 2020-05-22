Random rnd = new Random(10);
    System.out.println(rnd.nextInt());
    System.out.println(rnd.nextInt());
    System.out.println(rnd.nextInt());

    // do it again with the same seed
    rnd = new Random(10);
    System.out.println(rnd.nextInt());
    System.out.println(rnd.nextInt());
    System.out.println(rnd.nextInt());