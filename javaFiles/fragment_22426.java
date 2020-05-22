for (int i = 0; i < countA.length * 2; i++) {
    int indexInArray = i / 2;

    if (i % 2 == 0) {
        // Even, take from first
        System.out.println(countA[indexInArray]);
    } else {
        // Odd, take from second
        System.out.println(countB[indexInArray]);
    }
}