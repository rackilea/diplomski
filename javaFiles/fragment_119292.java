String s = "Hello dilip refer this url www.google.com. hi ramesh this is good for  android http://android.com";   
Pattern pc = Pattern.compile("((http://)|(www.))[A-Z,a-z]+.com");
Matcher matcher = pc.matcher(s);
while(matcher.find())
{
   System.out.println("String Extracted   "+matcher.group());
}