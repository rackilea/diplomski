String stringToProcess = "Test Test Hello World Test Test";
    String patternString = "Hello\\sWorld";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(stringToProcess);
    if (matcher.find()) {
        int start = matcher.start();
        int end = matcher.end();
        System.out.println(stringToProcess.substring(start, end));
    }