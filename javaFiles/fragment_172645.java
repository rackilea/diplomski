public static void main(String[] args) {
    Integer[] allCards = new Integer[52];
    for (int i = 0; i < allCards.length; i++) {
        allCards[i]=i;
    }
    List<Integer> cardList = new ArrayList<Integer>(Arrays.asList(allCards));
    Collections.shuffle(cardList);
    Integer[] cards = cardList.toArray(allCards.clone());

    Integer[] row1 = new Integer[13];
    Integer[] row2 = new Integer[13];
    Integer[] row3 = new Integer[13];
    Integer[] row4 = new Integer[13];

    int index = 0;
    System.arraycopy(cards, index, row1, 0, 13);
    index+=13;
    System.arraycopy(cards, index, row2, 0, 13);
    index+=13;
    System.arraycopy(cards, index, row3, 0, 13);
    index+=13;
    System.arraycopy(cards, index, row4, 0, 13);

    System.out.println(Arrays.toString(cards));
    System.out.println(Arrays.toString(row1));
    System.out.println(Arrays.toString(row2));
    System.out.println(Arrays.toString(row3));
    System.out.println(Arrays.toString(row4));


}