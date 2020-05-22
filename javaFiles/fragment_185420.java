class Pdeuchler {

    static Pdeuchler db;

    String[][] bookdb;


    public static String search(String term) {
        String result = "";
        int row = db.bookdb.length;

        outer_loop: // CHANGE #1 added a named loop
        for (int i=0; i<db.bookdb.length; i++) {
            for (int j=0; j<4; j++) {
                if (term.equals(db.bookdb[i][j])) {
                     row = i;
                     //break; //REMOVED
                     break outer_loop; // CHANGE #2 breaking to the outer_loop
                }
            }
        }

        if (row == db.bookdb.length) {
            result += "Your search failed to return any results";
        }
        else {
            for (int j=0; j<4; j++) {
                result += db.bookdb[row][j] + "    ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        db = new Pdeuchler();
        db.bookdb = new String[10][4]; // title, author, publisher, year

        db.bookdb[0] = new String[] {"Awesome Book","Stan","West","2001"};
        db.bookdb[1] = new String[] {"Cool Story","Dan","North","2002"};
        db.bookdb[2] = new String[] {"Brothers","North","North","2003"};
        db.bookdb[3] = new String[] {"Never again!","Bob","West","2004"};
        db.bookdb[4] = new String[] {"Howdy Partner","Stan","South","2005"};
        db.bookdb[5] = new String[] {"What the StackOverflow?","Dan","North","2006"};
        db.bookdb[6] = new String[] {"That's hilarious","Angie","South","2007"};
        db.bookdb[7] = new String[] {"I like pie","Angie","East","2008"};
        db.bookdb[8] = new String[] {"Bob writes a book","Bob","South","2009"};
        db.bookdb[9] = new String[] {"The adverntures of Bob","Bob","North","2010"};

        System.out.println(search("I like pie"));
        System.out.println(search("North"));
        System.out.println(search("Dan"));
    }

}