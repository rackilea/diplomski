private static List<List<Tile>> getListOfLists() {
    int numcol = 5;
    int numrow = 5;

    List<List<Tile>> bidiArray = new ArrayList<>();
    for (int i = 0; i < numcol; i++) {
        List<String> sublist = new ArrayList<>();
        bidiArray.add(sublist);
        for (int j = 0; j < numrow; j++) {
            sublist.add(null);
        }
    }
    return bidiArray;
}