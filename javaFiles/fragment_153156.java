String s = "log.debug(\"find by example successful, result size: \" + results.size(), exception);";
Pattern regex = Pattern.compile("log\\.(\\w+)\\((.+),");
 Matcher matcher = regex.matcher(s);
 while(matcher.find()){
        System.out.println(matcher.group(2));
}