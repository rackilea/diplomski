public static List<String> split(String input) {
    int nParens = 0;
    int start = 0;
    List<String> result = new ArrayList<>();
    for(int i=0; i<input.length(); i++) {
        switch(input.charAt(i)) {
        case ',':
            if(nParens == 0) {
                result.add(input.substring(start, i));
                start = i+1;
            }
            break;
        case '(':
            nParens++;
            break;
        case ')':
            nParens--;
            if(nParens < 0) 
                throw new IllegalArgumentException("Unbalanced parenthesis at offset #"+i);
            break;
        }
    }
    if(nParens > 0)
        throw new IllegalArgumentException("Missing closing parenthesis");
    result.add(input.substring(start));
    return result;
}