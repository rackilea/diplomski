String[] tags = { "<img src = \"the source\" class=class01 />",
                  "<img class=class02 src=folder/img02.jpg />",
                  "<img class= \"class03\" / >", 
                  "<img  foosrc=\"whatever\" barclass=noclass" +
                  "    class='class04' src =\nfolder/img04.jpg></img>" };

String regex = 
  "(?i)\\s+(src|class)\\s*=\\s*(?:\"([^\"]+)\"|'([^']+)'|(\\S+?)(?=\\s|/?\\s*>))";
Pattern p = Pattern.compile(regex);
int n = 1;
for (String tag : tags)
{
  System.out.printf("%ntag %d: %s%n", n++, tag);
  Matcher m = p.matcher(tag);
  while (m.find())
  {
    System.out.printf("%8s: %s%n", m.group(1),
        m.start(2) != -1 ? m.group(2) :
        m.start(3) != -1 ? m.group(3) :
        m.group(4));
  }
}