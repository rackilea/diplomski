double array[] = new double[10];
    int i;
    Scanner input = new Scanner(System.in);
    for (i = 0; i < 10; i++) {
        System.out.println("Give the " + (i + 1) + " number");
        array[i] = input.nextDouble();
    }
    double max = array[0], min = array[0];
    for (i = 0; i < 10; i++) {
        if (array[i] > max) {
            max = array[i];

        }

        if (array[i] < min) {
            min = array[i];
        }
    }
    System.out.println("The Max is :" + max);
    System.out.println("The Min is :" + min);