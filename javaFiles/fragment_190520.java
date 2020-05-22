while (matcher.find()) {
    for(int i = 1; i < (matcher.groupCount() + 1); i++) {
        String toReplace = matcher.group(i);
        System.out.println(toReplace);
    }
}