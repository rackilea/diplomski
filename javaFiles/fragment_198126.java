char x= 'A';
char y;
{
    y = x;
    x = x + 1;
}
x = y;
System.out.println(x);