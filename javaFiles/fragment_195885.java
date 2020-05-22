int maximum = 100;
    int minimum = 0;

    Random rn = new Random();
    int range = maximum - minimum + 1;
    int randomNum =  rn.nextInt(range) + minimum;
    System.out.println(randomNum);

    for (int i=0; i< 100; i++) {
        maximum = randomNum + 5;
        minimum = randomNum - 5;

        range = maximum - minimum + 1;
        randomNum =  rn.nextInt(range) + minimum;
        System.out.println(randomNum);
    }