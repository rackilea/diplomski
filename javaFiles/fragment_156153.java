public static int eval(String s){
    int result = 0;
    int sign = 1; 
    for(int i = 0; i < s.length(); i++){
        char current = s.charAt(i);
        switch (current)
        {
            case '+': break;
            case '-': sign *= -1; break;
            default: 
                result += sign * Character.getNumericValue(current);
                sign = 1;
                break;
        }
    }
    return result;
}