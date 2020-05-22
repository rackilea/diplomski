for (int i = 0; i < tokens.length; i++) {
    // ...
    if (tokens[i] >= '0' && tokens[i] <= '9') {
        StringBuilder sb = new StringBuilder();
        sb.append(tokens[i]);
        // There may be more than one digits in number
        while (i + 1 < tokens.length && tokens[i + 1] >= '0' && tokens[i + 1] <= '9') {
            sb.append(tokens[++i]);
        }
        values.push(Integer.parseInt(sb.toString()));
    }
    // ...
}