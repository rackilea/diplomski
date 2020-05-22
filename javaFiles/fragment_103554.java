switch (color) 
    { 
case 1: //Red 
System.out.println("Now enter an integer from 1 through 10."); 
int num1 = kbReader.nextInt(); 

switch (num1) 
        { 
case 1: 
case 3: 
case 5: 
case 7: 
case 9: 
    System.out.println(""); 

case 2: 
case 4: 
case 6: 
case 8: 
case 10: 
    System.out.println(""); 
    break; 
        } 

break;  <--- this is the addition
case 2: //Blue