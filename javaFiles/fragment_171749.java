FileInputStream fis = null;
try
{
    fis = new FileInputStream("C:/Users/Pingle/Desktop/Text.txt");
}
catch(Exception e)
{
}
Scanner ob = new Scanner(fis);
ob.useDelimiter("\n");
String str = "";
boolean started = false;
int ArticleNumber = 0;
while(ob.hasNext())
{
    String line = ob.next();
    if(line.trim().contains("{") && !started)
    {
        started = true;
        ArticleNumber++;
        continue;
    }
    if(line.trim().startsWith("}"))
    {
        started = false;
        System.out.println("Article "+ArticleNumber+" contains:\n"+str);
    }
    if(started)
    {
        str += line+"\n";
    }
}