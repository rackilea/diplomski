public static String do_conversion (String str)
{
char c;
String output = "{";

for(int i = 0; i < str.length(); i++)
{
c = str.charAt(i);

if(c=='e')
output += "{mathrm{e}}";

else if(c=='(')
output += '{';

else if(c==')')
output += '}';

else if(c=='+')
output += "{cplus}";

else if(c=='-')
output += "{cminus}";

else if(c=='*')
output += "{cdot}";

else if(c=='/')
output += "{cdivide}";

else output += c; // else copy the character normally
}

output += ", mathrm{d}x}";
return output;
}