public static void main(String args[]) 
{
  int a[] = new int[5];
  int i = 0; 
  Scanner in = new Scanner(System.in);
  while(i<5)
  {
  System.out.println("Enter an integer");
  a[i] = in.nextInt();
  i++;
  System.out.println("You entered integer "+a[i-1]);
  }

}