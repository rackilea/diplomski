public static void main (String [] args){
    String word = " Some random mobile numbers 0546 105 610, 451 518 9675, 54 67892 541";
    word = word.replaceAll("\\s+","");

    Pattern pat = Pattern.compile("(\\d{10})");
    Matcher mat = pat.matcher(word);

    while (mat.find()) {
        for (int i = 1; i <= mat.groupCount(); i++) {
            System.out.println(mat.group(i));
        }
    }
}