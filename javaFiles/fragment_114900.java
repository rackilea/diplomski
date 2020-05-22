Map<String,String> vars = new HashMap<>();
    String input = "SVR GAME MOVE {PLAYER: \"PLAYER\", MOVE: \"1\", DETAILS: \"\"}";
    Pattern pattern = Pattern.compile("([A-Za-z]+): \"([^\"]*)\"");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        vars.put(matcher.group(1), matcher.group(2));
    }