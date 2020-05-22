for(int i = 0; i < splitStr.length; i++) {
    String[] fract = splitStr[i].split("/");
    int num = Integer.valueOf(fract[0]);
    int den = 1;
    if(fract.length == 2){
        den = Integer.valueOf(fract[1]);
    }
    input[i] = new Fraction(num, den);
}