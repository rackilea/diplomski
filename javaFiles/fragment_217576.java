String token = "\\b\\S*overflow\\S*";
Pattern pattern = Pattern.compile(token);
Matcher matcher = pattern.matcher(fullText);
if (matcher.find())
{
     System.out.println("Whole word is :"+matcher.group());
}