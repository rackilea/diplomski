String s = "you are smart\n" + 
        "i and you not same\n" + 
        "This is not my fault\n" + 
        "Which one is yours";
Matcher m = Pattern.compile("(?m)^(?!.*\\byou\\b).*").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}