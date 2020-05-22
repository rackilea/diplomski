int sum = 1;
    int day = 1;
    while (sum > 0) {
        sum = 0;

        for (int x = 0; x < inhabitants.length; x++) {
            if (inhabitants[x] > 0)
                inhabitants[x] = inhabitants[x] / 2;
            sum += inhabitants[x];
        }
        System.out.println("Day " + day + " " + Arrays.toString(inhabitants));
        day++;
    }