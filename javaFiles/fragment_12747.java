public static void main(String args[]) throws FileNotFoundException {
    String line = "Suppose 49 are slicing a cake to divide it between 5 people. I cut myself a big slice, consisting of 33.3 percent of the whole cake. Now it is your turn to cut a slice of cake. Will you also cut a 33.3 percent slice? Or will you be fairer and divide the remaining 66.6 percent of the cake into 4 even parts? How big a slice will you cut?";
    String[] sp = line.split(" +"); // "+" for multiple spaces
    final String SPACE = " "; 

    // loop over the data
    for (int i = 0; i < sp.length; i++) {
        try {
            // if exception is not raised, IS A DOUBLE!
            Double.parseDouble(sp[i]);

            // if is not first position print previous word (avoid negative index)
            if (i > 0)
                System.out.print(sp[i - 1] + SPACE);

            // print number itself
            System.out.print(sp[i] + SPACE);

            // if is not last position print previous word (avoid IOOBE)
            if (i < sp.length - 1)
                System.out.print(sp[i + 1]);

            // next line!
            System.out.println();
        } catch (NumberFormatException ex) {
            // if is not a number, not our problem!
        }
    }
}