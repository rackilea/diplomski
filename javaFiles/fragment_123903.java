private static void shuffle(Card[] cardArray) {
    for (int i = 1; i <= 20; i++) {
        int a = randomInt();
        int b = randomInt();
        Card temp = cardArray[a];
        cardArray[a] = cardArray[b];
        cardArray[b] = temp;
    }
}

private static int randomInt() {   
    return (int)(Math.random() * 12);
}