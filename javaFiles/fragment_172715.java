// I'd, personally, make this protected as you may wish to change the how the search 
// is performed in the future.
protected void search8() {

    // You've assumed that there are only ever 40 elements
    // while you've allowed for a variable number of search positions
    // You would need (at least) (rowCount * colCount) * 2 elements to be
    // safe.  This is a little ridiculous considering that there might
    // only be 1 reuslt in the table
    // int[] sarr8 = new int[40]; <-- Don't really want to do this

    // Instead, we should use a dynamic array instead
    // The ArrayList is a Collection implementation backed by an array
    // but it has the means to grow (and shrink) to meet the capacity requirements
    List<Point> slist8 = new ArrayList<Point>(25); // <-- you could change the initial value as you see fit
    int i = 0;
    String target8 = sear8.getText();
    for (int row = 0; row < table8.getRowCount(); row++) {
        for (int col = 0; col < table8.getColumnCount(); col++) {
            String next8 = (String) table8.getValueAt(row, col);
            if (next8.contains(target8)) {
                // Okay, this kinda cheating, but we want to store col/row or x/y
                // cell coordinates.  You could make your own class "Cell" class,
                // but for what we want, this is exactly the same
                Point cell = new Point(col. row);
                //sarr8[i] = row;
                //sarr8[i + 1] = col;
                //i = i + 2;
                slist8.add(cell);
            }
        }
    }

    //System.out.println(sarr8.length);
    System.out.println(slist8.size());

    //for (int j = 0; j < sarr8.length; j += 2) {
    //    showSearchResults(sarr8[j], sarr8[j + 1]);
    //    return;
    //}

    // Now, personally, I'd pass in the whole result set to the "showSearchResults"
    // method, because, IMHO, that's the methods domain of responsibility, ours was
    // to simply find the results.

    showSearchResults(slist8);

    // At this point, the showSearchResults method can determine how it wants to display
    // the search results

}