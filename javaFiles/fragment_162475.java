int[][] sales = new int[6][8];

    // a
    for (int i = 0; i < sales.length; i++) {
        int sum = 0;
        for (int j = 0; j < sales[i].length; j++) {
            sum += j;
        }
        System.out.println("Location " + String.valueOf(i) + " has "
                + String.valueOf(sum) + " anvils sold");
    }

    // b
    for (int i = 0; i < sales[0].length; i++) {
        int unpopular = 0;
        for (int j = 0; j < sales.length; j++) {
            if (sales[j][i] > 0) {
                unpopular++;
            }
            if (unpopular >= 3) {
                break;
            }
        }
        if (unpopular < 3) {
            System.out.println("Modle " + String.valueOf(i)
                    + " is un popular");
        }
    }

    // c3
    int max = -1;
    int maxLocation = -1;
    for (int i = 0; i < sales.length; i++) {
        int sum = 0;
        for (int j = 0; j < sales[i].length; j++) {
            sum += j;
        }
        if (sum > max) {
            max = sum;
            maxLocation = i;
        }
    }
    System.out.println("Location " + String.valueOf(maxLocation)
            + " has most hardworking employees");

    // d
    int min = 25 * 8 + 1;
    ;
    int minLocation = -1;
    for (int i = 0; i < sales.length; i++) {
        int sum = 0;
        for (int j = 0; j < sales[i].length; j++) {
            sum += j;
        }
        if (sum < min) {
            min = sum;
            minLocation = i;
        }
    }
    System.out.println("Location " + String.valueOf(minLocation)
            + " has most hardworking employees");