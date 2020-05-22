// print shuffled deck
for (int i = 0; i < 4; i++) {
    System.out.println("** Person " + (i + 1) + " **");
    for (int j = 0; j < 5; j++) {
        System.out.println(deck[i + j * 4] + " (Card " + (i + j * 4) + ")");
    }
}