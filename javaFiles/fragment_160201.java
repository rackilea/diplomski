String test = "\n\n\ttest\n\n\r\rtest\r\r\n\ntest";
    StringTokenizer tokenizer = new StringTokenizer(test);
    StringBuilder builder = new StringBuilder();
    while (tokenizer.hasMoreTokens()) {
        String string = tokenizer.nextToken();
        builder.append(string).append('\n');
    }
    System.out.println("Final Result:\n" + builder.toString());