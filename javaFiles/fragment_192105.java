String str = "A10102012MikeM";

String p = "^([A|P])(\\d+)(\\w+?)(M|F)$";
Pattern pattern = Pattern.compile(p);
Matcher matcher = pattern.matcher(str);
if (matcher.find()){
System.out.println(matcher.group(1));
System.out.println(matcher.group(2));
System.out.println(matcher.group(3));
System.out.println(matcher.group(4));
}