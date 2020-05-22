class StringFragementation {

    public static String[] mymethod(String mystring) {
        String[] split = mystring.split("_");
        return split;
    }
    public static void main(String[] args) {

        String[] singapore = new String[9];
        String s = "Netherlands_Iceland_Norway_Denmark_Usa_Brazil_Argentina_Colombuia_Bolivia_";
        singapore = mymethod(s);
        for (int col = 0; col < 9; col++) {
            System.out.println(singapore[col]);

        }
    }
}