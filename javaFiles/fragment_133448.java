int myNum = 11; // myNum is 11
int mySum = 0; // mySum is 0

while (myNum >= 0) // repeat the next block (between {}) while myNum is positive or 0
{
    myNum--; // decrease myNum by 1
    mySum += myNum * 5; // add 5 times myNum to mySum
}

System.out.println ("myNum: " + myNum); // output "myNum: " followed by myNum value
System.out.println ("mySum: " + mySum); // same as above by with mySum