public static final String INT_MAX_VALUE = "2147483647";
public static final String LONG_MAX_VALUE = "9223372036854775807";

public static Number stringToMinimalNumberWithoutBigInteger(String numberStr){
    //Removing the minus sign to test the value
    String s = (numberStr.startsWith("-") ? numberStr.substring(1,numberStr.length()) : numberStr);

    if(compareStringNumber(s, LONG_MAX_VALUE) > 0){
        return new BigInteger(numberStr);
    } else if(compareStringNumber(s, INT_MAX_VALUE) > 0){
        return new Long(numberStr);
    } else {
        return new Integer(numberStr);
    }
}

//return postive if a > b, negative if a < b, 0 if equals;
private static int compareStringNumber(String a, String b){
    if(a.length() != b.length()){
        return a.length() - b.length();
    }
    for(int i = 0; i < a.length(); i++){
        if( a.codePointAt(i) != b.codePointAt(i) ){ //Or charAt()
            return a.codePointAt(i) - b.codePointAt(i);
        }
    }
    return 0;
}