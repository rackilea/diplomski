public static char[] toCharArray(String input){
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        char[] chars = new char[stringTokenizer.countTokens()];

        for (int i = 0; i < chars.length; i++)
            chars[i] = stringTokenizer.nextToken().charAt(0);

        return chars;
    }