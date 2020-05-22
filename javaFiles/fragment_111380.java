String text = "There's \"a man\" that live next door "
        + "'in my neighborhood', \"and he gets me down...\"";

    Scanner sc = new Scanner(text);
    Pattern pattern = Pattern.compile(
        "\"[^\"]*\"" +
        "|'[^']*'" +
        "|[A-Za-z']+"
    );
    String token;
    while ((token = sc.findInLine(pattern)) != null) {
        System.out.println("[" + token + "]");
    }