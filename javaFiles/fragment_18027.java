int fact = 1;
int i = 1;
while (count <=10) {       
     while(i<=number) {            
         fact = fact * i;
         i++;
     }
     System.out.println("Factorial of "+number+" is: "+fact);
     number++;
     count++;
}