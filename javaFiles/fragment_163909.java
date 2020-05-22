public static String toString(int i) {  
    switch(i) {  
        case Integer.MIN_VALUE: return "-2147483648";  
        case -3: return "-3";  
        case -2: return "-2";  
        case -1: return "-1";  
        case 0: return "0";  
        case 1: return "1";  
        case 2: return "2";  
        case 3: return "3";  
        case 4: return "4";  
        case 5: return "5";  
        case 6: return "6";  
        case 7: return "7";  
        case 8: return "8";  
        case 9: return "9";  
        case 10: return "10";  
    }  
    char[] buf = (char[])(perThreadBuffer.get());  
    int charPos = getChars(i, buf);  
    return new String(buf, charPos, 12 - charPos);  
}