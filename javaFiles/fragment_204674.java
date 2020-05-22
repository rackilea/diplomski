Iterable<String> result = 
        Splitter.on(CharMatcher.anyOf("/")).
                limit(4).
                split("https://stackoverflow.com/questions/ask");

if (Lists.newArrayList(result).size() > 3) {
    System.out.println(Lists.newArrayList(result).get(3));
}else{
    System.out.println("NOTHING");
}