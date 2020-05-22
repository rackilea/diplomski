int numberOfYears = 0;
while(mexicoPop < usPop / 2)
{
    mexicoPop = mexicoPop + mexicoPop * .07; // since the RHS would be changing every year
    usPop = usPop + usPop * .02;    
    numberOfYears++; 
}
System.out.println(numberOfYears);