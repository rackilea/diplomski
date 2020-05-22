public static int base = 60;

public static void main(String[] args) {
    long test =0x7FFFFFFFFFFFFFFFL;
    System.out.println(test+ " -> "+convertBase10toCustomBase(test));

    String test2 = "FFDYWVtKFU7";
    System.out.println(test2+" -> "+convertCustomBasetoBase10(test2));

}
public static String convertBase10toCustomBase(long n){
    boolean negative = (n<0); // Remembers if n is negative.
    if (negative) n=-n; // Now works with a positive number
    String result= "";
    do {
        result= getBase((int)(n%base))+result;
        n/=base;
    }while(n>0);

    if(negative) result="-"+result;

    return result;
}
public static char getBase(int n){
    if(n<=9)
        return (char)(n+'0'); // Returns the char from numeric value
    if(n <35)
        return (char)('A'+ n -10); // Returns char in UpperCase if 9 < n < n+base 
    return (char)('a'+ n -36); // Returns in LowerCase otherwise
}

public static long convertCustomBasetoBase10(String s){

    boolean isNegative=false; // Remembers if the String starts with "-"
    if(s.charAt(0)=='-'){
        isNegative = true;
        s=s.substring(1); // Removes the "-" if negative
    }

    long result = 0;

    // Each char from right to left will be converted to a numeric value
    // Each numeric value must be multiplied by a certain power depending on its position, then added to previous ones.
    for (int i =0; i<s.length();i++)
        result += Math.pow(base,i)*getBase10(s.charAt(s.length()-i-1)); 

    if(isNegative) return -result;

    return result;

}
public static int getBase10(char c){
    // If the char represents a number, just return its value
    if (!Character.isLetter(c))
        return Character.getNumericValue(c);

    // If the char is UpperCase, we substract from it 
    // the value of 'A' and add 10 so that the first char A = 10
    if(Character.isUpperCase(c))
        return c -'A'+10;
    // If LowerCase, we substract  the value of 'a' and add 10+26
    return c-'a'+36;
}