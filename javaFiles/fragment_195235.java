String s = "*?ref_=xoxoxo\"><img src=\"*http://www.wow-how.com/yaba-daba-doo.jpg\"";
Pattern regex = Pattern.compile("(?<=\\?ref_=xoxoxo\"><img src=\"\\*)[^\"]*");
Matcher matcher = regex.matcher(s);
while(matcher.find()){
       System.out.println(matcher.group(0));
    }