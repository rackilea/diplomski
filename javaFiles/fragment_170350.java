String oldLine = null;
StringBuilder sb = new StringBuilder ();
int x = 4;
for (int i = 0; i < 10; i++)
{
    int result = x + i;
    sb.append (String.valueOf (result));
    sb.append ('\t');
}

oldLine = sb.toString ();
System.out.println (oldLine);