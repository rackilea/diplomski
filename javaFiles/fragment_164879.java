int matchCounter = 0;
    Arrays.sort(biggest);
    for (char c : smallest) {
        if (Arrays.binarySearch(biggest, c) >= 0) {
            matchCounter++;
        }
    }
    System.out.println(matchCounter); // 4