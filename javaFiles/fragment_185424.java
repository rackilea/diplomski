public static String search2(String term) {
    String result = "";
    int row = db.bookdb.length;

    for (int i=0; i<db.bookdb.length; i++) {
        for (int j=0; j<4; j++) {
            if (term.equals(db.bookdb[i][j])) {
                 row = i;
                 for (int k=0; k<4; k++) {
                     result += db.bookdb[i][k] + "    ";
                 }
                 result += "\n";
                 break; // breaks out of the INNER (j) loop
            }
        }
    }

    if (row == db.bookdb.length) {
        result += "Your search failed to return any results";
    }
    return result;
}