Scanner z = new Scanner(System.in);
//int n;
long n;//long to display all prime factors.
List primefactors = new ArrayList():
System.out.print("Enter a Number : ");
//n= z.nextInt();
n = z.nextLong();
System.out.print("The Prime Factors of "+n+" are : "); 
int i=2;
while(n>1)
  {
   if(n%i == 0)
    {
     primefactors.add(i);
     n=n/i;
    }
   else
    i++;
  }
System.out.println(Collections.min(primefactors));
primefactors.forEach(System.out::println);//to display all values