while (matcher.find()) {
    //tagValues.add(matcher.group(1));
    System.out.print("Start index: " + matcher.start(1));
    System.out.println(" End index: " + matcher.end(1));
    tagValues.add(String.format("[%d,%d]", matcher.start(1), matcher.end(1)));
}