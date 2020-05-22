Double largest = customer[0].getBalance();
String name = "";

for (int i=0; i<customer.length; i++)
{
     if(customer[i].getBalance() > largest) 
     {
            largest = customer[i].getBalance();
            name = customer[i].getName();
      }
 }
 System.out.println("The highest balance is " + largest);
 System.out.println("The name of the customer is " + name);