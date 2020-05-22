System.out.println("Enter the amount of people in your group, up to 6");
int num = input.nextInt();
// discard the rest of the first line and 
// expect the next input to be on the next line.
input.nextLine(); 

System.out.println("Please enter the desiered row, A-E. Enter capitals.");
String ROW = input.nextLine();