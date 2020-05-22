public static String conCat(String a, String b) {
    //If either String is empty, we want to return the other.
    if (a.isEmpty()) return b;
    else if (b.isEmpty()) return a;
    else {
        //If the last character of a is the same as the first character of b:
        //Since chars are primitives, you can (only) compare them with ==
        if (a.charAt(a.length()-1) == b.charAt(0))
            return a + b.subString(1);
        //Otherwise, just concatenate them.
        else
            return a + b;
    }
}