for (int i = 0; i < tokens.length; i++) {
    // ...
    if (tokens[i] >= '0' && tokens[i] <= '9')
    {
        StringBuffer sbuf = new StringBuffer();
        // There may be more than one digits in number
        while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
            sbuf.append(tokens[i++]);
        values.push(Integer.parseInt(sbuf.toString()));
    }
    // ...
}