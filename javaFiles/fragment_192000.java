public void assemble(int selection, int position) {
    // create list of columns
    List<List<Card>> columns = Arrays.asList(column1, column2, column3);

    // if selected column is not located at position, swap:
    if (selection != position) {
        List<Card> temp = columns.get(position);
        columns.set(position, columns.get(selection));
        columns.set(selection, temp);
    }

    // add all columns to trickDeck in order
    columns.forEach(trickDeck::addAll);
}