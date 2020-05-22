String[] creatures = {"Dog", "Cat", "Fish", "Monkey", "Horse"};
    Random r = new Random();

    for (int i = 0; i < 5; i++) {
        String creature1 = creatures[r.nextInt(creatures.length)];
        String creature2 = creatures[r.nextInt(creatures.length)];
        String creature3 = creatures[r.nextInt(creatures.length)];
        String creature4 = creatures[r.nextInt(creatures.length)];
        String creature5 = creatures[r.nextInt(creatures.length)];

        System.out.println(creature1 + " " + creature2 + " " + creature3
                + " " + creature4 + " " + creature5);

    }