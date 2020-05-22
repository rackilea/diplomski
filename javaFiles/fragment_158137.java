public class Main {
    public static void main(String[] args) {
        String[][] array2d = createArray();

        int charSeqColumn = 0;
        CharSequence charSequnce = new Array2DColumnCharSequnce(array2d, charSeqColumn);

        System.out.println(charSequnce.toString());

        Pattern patttern = Pattern.compile("ext");
        Matcher matcher = patttern.matcher(charSequnce);

        while (matcher.find()) {
            String matchGroup = matcher.group();
            int start = matcher.start();
            int end = matcher.end() - 1;

            String msg = MessageFormat.format("{0} matched at: [{1}] - [{2}]", matchGroup, start, end);
            System.out.println(msg);
        }
    }

    private static String[][] createArray() {
        String[][] array2d = new String[2][10];
        array2d[0][0] = "N";
        array2d[0][1] = "e";
        array2d[0][2] = "x";
        array2d[0][3] = "t";
        array2d[0][4] = " ";
        array2d[0][5] = "N";
        array2d[0][6] = "e";
        array2d[0][7] = "x";
        array2d[0][8] = "t";
        array2d[0][9] = " ";

        array2d[1][0] = "H";
        array2d[1][1] = "e";
        array2d[1][2] = "l";
        array2d[1][3] = "l";
        array2d[1][4] = "o";
        array2d[1][5] = "W";
        array2d[1][6] = "o";
        array2d[1][7] = "r";
        array2d[1][8] = "l";
        array2d[1][9] = "d";
        return array2d;
    }
}