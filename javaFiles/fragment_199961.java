String text = jTextPane1.getDocument().getText(position, 1); 
System.out.println(text);

if (text.equals(")"))
{
    System.out.println("matches");
}
else
{
    System.out.println("doesn't match");
}