Scanner myScanner = new Scanner(System.in);
int count = 0;
int number = myScanner.nextInt();
while (count <=10) {

     int fact = 1;
     int i = 1;

     while(i<=number) {         
         fact = fact * i;
         i++;
     }
     System.out.println("Factorial of "+number+" is: "+fact);
     number++;
     count++;
}