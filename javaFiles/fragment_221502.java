public static boolean check(String text){
    long xCounter = 0;
    long yCounter = 0;
    for (char ch : text.toCharArray()){
        if (ch=='x') xCounter++;
        else if (ch=='y') yCounter++;
        else return false;//non x or y appeared
    }
    return xCounter < 2 || yCounter < 2;
}