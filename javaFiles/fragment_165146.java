int sum=0;
double average;

int lowerBound = 1;
int upperBound = 100;

  while(lowerBound<=upperBound) {

       sum = sum+lowerBound;
       lowerBound++;
       } 
System.out.println("The Sum is "+sum);
average=(double)sum/upperBound;            //change
System.out.println("The average is " + average);