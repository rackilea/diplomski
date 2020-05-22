String[] lines = message.split("\n"); //considering that message variable holds the String
String msg="";

for(int cnt = 0;cnt<lines.length;cnt++)
{
    if(!lines[cnt].contains("FALSE"))
    {    
        msg+=lines[cnt]+"\n";
    }
}
System.out.println(msg);