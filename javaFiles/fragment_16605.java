String var = "p_start_date";

Pattern pattern = Pattern.compile("_([a-z])");
Matcher matcher = pattern.matcher(var);

StringBuffer sb=new StringBuffer();
while(matcher.find()) {
    matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
}
matcher.appendTail(sb);

System.out.println(sb);