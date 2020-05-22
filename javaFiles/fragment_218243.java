int n;
do {
    n += rand.nextInt(100) + 1;
    System.out.println(n);
    System.out.println("Try again?");
    s = quest.nextBoolean();
} while (s != false);