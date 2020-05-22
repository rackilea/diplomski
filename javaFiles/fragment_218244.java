int n;
do {
    int tmp;
    tmp = rand.nextInt(100) + 1;
    n += tmp;
    System.out.println(tmp+" Total: "+n);
    System.out.println("Try again?");
    s = quest.nextBoolean();
} while (s != false);