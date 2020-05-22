Scanner stdin = new Scanner(System.in); 
int num = 1;
// uncomment if u not want to use default value
// num = stdin.nextInt();
do
{
    if (num % 2 == 0)
     {
        System.out.print(num + " ");
     }
    num = stdin.nextInt();
}
while(num > 0);