String input = "q={!tag=tagForType}(Type:(ABC OR XyZ OR ORT))(Type:(ABC))";
    Pattern findType = Pattern.compile("Type:(\\([ \\w]+\\))");
    Pattern extractLists = Pattern.compile("(\\(| OR )([\\w]+)");
    Matcher typeMatcher = findType.matcher(input);
    while (typeMatcher.find()) {
        System.out.println(typeMatcher.group(1));

        Matcher listMatcher = extractLists.matcher(typeMatcher.group(1));
        while (listMatcher.find()) {
            System.out.println(listMatcher.group(2));
        }
    }