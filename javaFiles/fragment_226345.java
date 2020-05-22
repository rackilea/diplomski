String text = "SampleFilter('x','y','z') AND TestFilter('a','b','c')"
            + " AND SampleFilter('d','e','f')";
    Pattern re = Pattern.compile("SampleFilter\\((.*?)\\)");
    Matcher matcher = re.matcher(text);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }