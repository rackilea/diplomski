public class OneHundred {

    /**
    * leave specific number of digit after the dot
    * return myNum
    */
    private static double doMath(int i, int num) {
        double myNum = ((double) i / num) * 100;
        int precision = 100; //Number of zero = number of digits
        myNum = Math.floor(myNum * precision + .5) / precision;
        return myNum;
    }

    /**
     * Color from red to green according to the result
     * @param a
     * @return a haxaecimal to color the answer
     */
    private static String colorOnDigit(double a) {
        double green, red;
        int g, r;
        double power = a;
        int blue = 0;

        green = 255 * Math.sqrt( Math.cos ( power * Math.PI / 200 ));
        red = 255 * Math.sqrt( Math.sin ( power * Math.PI / 200 ));

        int precision = 10; //Number of zero = number of digits
        green = Math.floor(green * precision + .5) / precision;
        red = Math.floor(red * precision + .5) / precision;

        r = (int) red;
        g = (int) green;

        String hex = String.format("#%02x%02x%02x", r, g, blue);

        System.out.println("blue " + blue);
        System.out.println("Green " + green);
        System.out.println("Red " + red);
        System.out.println("----------");
        return "<font color = \"" + hex + "\">";
    }

    /**
     * convert the number to string 
     * @param i
     * @return a string that contains the information
     */
    private static String appendString(StringBuilder b, int i, int input){
        double a = doMath(i, input /* assumed an arbitrary input*/ );

        String s = "<br>" + colorOnDigit(a) + i + " : " + a + "</font>\n";

        return b.append(s).toString();
    }

    private static String print100(int num) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i < 100 + 1; i++) {
            appendString(text, i, num);
        }

        return text.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String l = print100(7);
        System.err.println(l);
    }

}