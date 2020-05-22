public static long decode(String textbytes) {
    long result=0;

    for(char ch : textbytes.toCharArray()) {
        result = result << 1;
        if(ch == '1')
            result = result + 1;
    }

    return result;
}