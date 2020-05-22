String s = "word word word {{t:word word|word}} word word {{t:word|word}} word word";
Pattern p = Pattern.compile("\\{\\{t:(.*?)\\}\\}");
Matcher m = p.matcher(s);
while (m.find()) {
    //System.out.println(m.group(1));
            System.out.println(m.group());
}