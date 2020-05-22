for (int i = 0; i < charAlp.length ; i++)
{
   if(charAlp[i] == 'a')
    charAlp[i]= 'b';
   else if(charAlp[i] == 'b')
    charAlp[i]= 'c';
   else if(charAlp[i] == 'c')
    charAlp[i]= 'a';
}
System.out.println(charAlp);