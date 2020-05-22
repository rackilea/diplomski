int x=100;
int y=200;
int foo(int x)
 return x+y;-~~~~~~~~~~~> which x :-( the one that I have got as a parameter or the global one.

int main()
{
   int x=2;
   printf("%d\n",foo(x));
}