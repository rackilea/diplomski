String text = "camel crime care cool medium melt home";

    final Pattern PATTERN = Pattern.compile("(^c\\w+)|\\s(c\\w+)|(\\w*me\\w*)");

    // Save all matches
    List<String> wordsStartingWithC = new ArrayList<>();
    List<String> wordsIncludingMe = new ArrayList<>();

    for (Matcher m = PATTERN.matcher(text); m.find();) {
        if(m.group(1) != null) {
            wordsStartingWithC.add(m.group(1));
        } else if(m.group(2) != null) {
            wordsStartingWithC.add(m.group(2));
        } else if(m.group(3) != null) {
            wordsIncludingMe.add(m.group(3));
        }
    }

    System.out.println(wordsStartingWithC);
    System.out.println(wordsIncludingMe);