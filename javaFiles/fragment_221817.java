int totalFibos=20;
int fibs[] = new int[totalFibos];

int a=0;
int b=1;
int fib=0;
fibs[0]=0;

fibs[1]=1;

int fibCounter=2;
while(fibCounter<totalFibos)
{
    fib=a+b;
    a=b;
    b=fib;
    fibs[fibCounter]=fib;
    fibCounter++;
}
System.out.println("\n\nThe first "+ totalFibos + " fibonacci numbers are: ");
int i=0;

while(i<totalFibos)
{
    System.out.print(fibs[i]+" ");
    i=i+1;
}
System.out.println();
int userInput=0;
i=0;
Scanner sc= new Scanner(System.in);
int found=0;
while(userInput!=-1)
{
    System.out.println("Enter a number to search,(enter -1 to end the search): "); //Shouldnt this be println ?
    userInput= sc.nextInt();
    i=0; //Reset it, else the second search would fail
    found=0; //Reset it, else the second search would fail
    while (i<totalFibos)
    {
        if(userInput==fibs[i]);
        {
            found=1;
            break;
        }
        i++; //Change state of i

    }
    if (found==1) { //Wheres your bracket ?
       System.out.println("The number: " + userInput + " is found at location: "+ Integer.toString(i+1)); //Just to be sure...
    }
    else if (found==0) {
       System.out.println("The number: "+ userInput + " is not found");
    }
 }
    if(userInput==-1)
        System.out.println("\nThanks");
    }