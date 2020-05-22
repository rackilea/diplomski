Random r = new Random();

    int[] num = new int[3]; // same as "= {0,0,0,0,0}
    int tCount = 0, fCount = 0;
    boolean gameResult = true;

    for (int i = 0; i < num.length; i++) {
        num[i] = r.nextInt(100) + 1;

        if (num[i] % 2 == 0) {
            System.out.println("TRUE - " + num[i] + " is divisible by 2.");
            tCount++;
        } else {
            System.out.println("FALSE - " + num[i]
                    + " is not divisible by 2.");
            fCount++;
            gameResult = false;
        }

    }

    System.out.println("True:" + tCount + "False:" + fCount);

    if (gameResult) {
        System.out.println("You Won");

    } else {
        System.out.println("You Lost");
    }

}
}