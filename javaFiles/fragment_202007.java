for(int i = 0 ; i < ch.length ; i++)
{
    if (ch[i] == 'h' && ch[i+1] == 'e')
    {
       ch[i] = ' ';
       ch[i + 1] = ' ';
       i = i +2;
    }
    else
    {
       e +=ch[i];
    }
}