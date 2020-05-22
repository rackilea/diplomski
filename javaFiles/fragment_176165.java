IParser parser = i.getInstance(IParser.class);
    IParseResult parseResult = parser.parse(new InputStreamReader(new StringInputStream("element a\nelement a\nxxxx")));
    for (INode e : parseResult.getSyntaxErrors()) {
        System.out.println(e.getSyntaxErrorMessage());
        System.out.println(e.getStartLine());
                    System.out.println(e.getText());
    }