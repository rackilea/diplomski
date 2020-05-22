String wordlist[]={"one","two","three","four","five"};
String input="I have three no, fourteen strings";

StringBuilder regexBuilder = new StringBuilder("\\b").append("(").append(String.join("|", wordlist)).append(")").append("\\b");
String regexExp = regexBuilder.toString();
regexBuilder.setLength(0);

Pattern p = Pattern.compile(regexExp);
Matcher matcher = p.matcher(input);

int count = 0;
while (matcher.find())
{
      System.out.println(matcher.group());
      count++;
}

if( count == 0){
    System.out.println("No Match Found");
}