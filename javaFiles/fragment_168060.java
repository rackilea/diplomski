public static void main(String... args) {
    String[] cards =
        { "A@", "A#", "A$", "A&", "2@", "3@", "4@", "5@", "6@", "7@", "8@", "9@",
            "10@", "K@", "Q@", "J@", "2#", "3#", "4#", "5#", "6#", "7#", "8#",
            "9#", "10#", "K#", "J#", "2$", "3$", "4$", "5$", "6$", "7$", "8$",
            "9$", "10$", "K$", "Q$", "J$", "2&", "3&", "4&", "5&", "6&", "7&",
            "8&", "9&", "10&", "K&", "Q&", "J&", "Q#" };

    List<String> list = Arrays.asList(cards);

    Collections.shuffle(list);
    final int columns = 7;
    final int rows = 7;
    int card = 0;

    // loop over rows
    for (int i=0; i<rows; i++) {
        // Fill empty columns in this row
        for (int j=0; j<i; j++) {
            System.out.print("\t");
        }
        // Add #columns - row# cards to this row
        for (int j=i; j<columns; j++) {
            System.out.print(list.get(card++) + "\t");
        }
        // advance to next row
        System.out.println();
    }
}