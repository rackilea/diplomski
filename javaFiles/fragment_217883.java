String data="xxxx[#aaaaaa]yyyyy[#bbbbbb]zzzzzz[/#bbbbbb]yyyyy[/#aaaaaa]zzzzzz";

Pattern p=Pattern.compile("(?=(\\[(#[0-9a-fA-F]{6})\\].*?\\[/\\2\\]))");
Matcher m=p.matcher(data);
while(m.find())
    System.out.println(m.group(1));