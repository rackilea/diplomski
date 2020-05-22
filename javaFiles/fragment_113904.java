Pattern pattern = Pattern.compile("^key (\\w+(?: \\w+)*) ([\\w.]++);$", Pattern.MULTILINE);
Matcher matcher = pattern.matcher("key public direct routing.key;\nkey direct routingkey;");
while (matcher.find()) {
    for (final String modifier : matcher.group(1).split(" "))
        System.out.println(modifier);
    System.out.println(matcher.group(2));
}