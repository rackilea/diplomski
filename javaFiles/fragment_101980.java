String str = "552 s East and west we are the best";
    String[] arr = str.split(" ", 3);
    String partOne = arr[0];
    char partTwo = arr[1].charAt(0);
    String partThree = arr[2];

    System.out.println("part one: "+partOne);
    System.out.println("part two: "+partTwo);
    System.out.println("part three: "+partThree);