String s = "if value=StartTopic topic=testParser, multiCopy=false, required=true, all=false, path=/Return/ReturnData/IRSW2";
String regex= "path=[^\\,]*";

Pattern p = Pattern.compile(regex);

Matcher m = p.matcher(s);

if(m.find()) {
    System.out.println(m.group());
}