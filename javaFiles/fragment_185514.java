System.out.print("Enter a number: ");
int a = Integer.parseInt(in.readLine());
System.out.print("Enter a number: ");
int b = Integer.parseInt(in.readLine());
System.out.print("Enter a number: ");
int c = Integer.parseInt(in.readLine());

for(int i = a; i < c; i++)
{
   if(i != b)
      System.out.println(i);
}