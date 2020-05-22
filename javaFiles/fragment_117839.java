final String regex = "(?: (\\w+) ([\\w\\d]+) (\\d+\\:\\d+) (ARRIVED|ON TIME))";
final String string = "Country number Time Status USA B30111 11:15 ARRIVED PARIS NC0120 14:40 ON TIME DUBAI RA007 14:45 ON TIME\n\n\n";
final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
        System.out.println("country =" + matcher.group(1));
        System.out.println("number =" + matcher.group(2));
        System.out.println("time =" + matcher.group(3));
        System.out.println("status =" + matcher.group(4));
        System.out.println("");
}