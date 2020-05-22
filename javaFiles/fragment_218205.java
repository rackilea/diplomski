String str = "ABC---DEF***GHI///JKL#@!";
Matcher m = Pattern.compile("([A-Za-z0-9]*)([^A-Za-z0-9]*)").matcher(str);
List<String> result = new ArrayList<>();
while(m.find()) {
    for(int i=1; i<=m.groupCount(); i++) {
        if(!m.group(i).isEmpty()) {
            result.add(m.group(i));
        }
    }
}
System.out.println(StringUtils.join(result, ", "));