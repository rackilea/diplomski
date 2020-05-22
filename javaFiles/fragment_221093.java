public static String pad_num(String line, String operator){
    //prevent ArrayIndexOutOfBoundsException
    if(!line.contains(operator)) {
        return line;
    }

    //prevent PatternSyntaxException by compiling it as literal
    String[] groups = Pattern.compile(operator, Pattern.LITERAL).split(line);

    //do the same
    ...

    return left+operator+right;
}