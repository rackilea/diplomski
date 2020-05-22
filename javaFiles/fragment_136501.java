String data = "a==b&c>=d|e<=f&!x==y";

Pattern p = Pattern.compile(
        "&!"+  // &! 
        "|" +  // OR 
        "&" +  // & 
        "|" +  // OR
        "\\|"  // since | in regex is OR we need to use to backslashes 
               // before it -> \\| to turn off its special meaning
        );
StringBuffer sb = new StringBuffer();
Matcher m = p.matcher(data);
while(m.find()){
    m.appendReplacement(sb, "\n"+m.group()+"\n");
}
m.appendTail(sb);
System.out.println(sb);