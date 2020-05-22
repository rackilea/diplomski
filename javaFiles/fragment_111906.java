ArrayList myArray = new ArrayList();
    ArrayList secArray = new ArrayList();

    Random rand = new Random();
    int p1;
    int p2;

    do {

        p1 = (rand.nextInt(60 - 50) + 50);

        while (myArray.contains(p1))
        {
            p1 = (rand.nextInt(60 - 50) + 50);
        }

        p2 = (rand.nextInt(60 - 50) + 50);

        while (secArray.contains(p2))
        {
            p2 = (rand.nextInt(60 - 50) + 50);
        }

        myArray.add(p1);
        secArray.add(p2);