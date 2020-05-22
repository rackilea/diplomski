String s;
StringBuilder text = new StringBuilder();
while((j=br.read())!=-1)
{
    char ch=(char)j;
    s=new String (String.valueOf(ch));
    System.out.print(s);
    text.append(s);
}
ta.setText(text.toString());

f1.close();