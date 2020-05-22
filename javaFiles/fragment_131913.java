Pattern pattern = Pattern.compile("(\\d+)");
Matcher matcher = pattern.matcher(s);
Set<Integer> numbers = new TreeSet<>();

while(matcher.find()) {
    numbers.add(Integer.parseInt(matcher.group(1)));
}