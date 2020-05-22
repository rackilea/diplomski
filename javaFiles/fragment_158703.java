String input = "http://en.wordpress.com/tag/1000-things-we-hate/";
// Assuming that all urls start with "http://"
int finish = input.indexOf("/", 7);
if(finish == -1)
{
  finish = input.length();
}
System.out.println(input.substring(7, finish));