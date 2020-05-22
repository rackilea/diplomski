// Scanner grade=new Scanner(System.in);// no need to create another scanner 
int total=0;
int g = 0;
String outputString = "";
while(true) {  // Create an infinite loop
    System.out.println("enter grade (enter 0 to stop entering grade):  ");
    g = mname.nextInt();
    if(g == 0) { // Break from the infinite loop if the user entered 0
        break;
    }
    outputString += g + " ";
    total +=g;
}