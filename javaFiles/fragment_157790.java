List<List<String>> list = new ArrayList<>();

    Pattern pattern = Pattern.compile("continents=(.+?) end ");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) { 
        List<String> innerList = new ArrayList<>();
        innerList.add("continents");
        String value = matcher.group(1);
        innerList.add(value);
        list.add(innerList);
    }