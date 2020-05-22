boolean fizz = i % 3 == 0;
boolean buzz = i % 5 == 0;

if (fizz) 
   System.out.print("Fizz");
if (buzz)
   System.out.print("Buzz");
if (!(fizz || buzz))
   System.out.print(i);

System.out.println();