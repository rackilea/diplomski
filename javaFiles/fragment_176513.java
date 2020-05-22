String name;
String id;
int payRate;
int[] hours = new int[5];
int avgHours;
int totalPay;
int totalHours = 0;
int counter;
int overTime = 0;
Scanner input = new Scanner(System.in);
//housekeeping
System.out.print("Enter the Employee's name: ");
String inputString = input.nextLine();
name = inputString;

System.out.print("Enter the Employee's ID: ");
inputString = input.nextLine();
id = inputString;

System.out.print("Enter the Employee's pay rate: ");
inputString = input.nextLine();
payRate = Integer.parseInt(inputString);

//hoursPay
counter = 0;
for (hours[counter] = 0; counter < 5; counter++) {
System.out.print("How many hours did the employee work? ");
inputString = input.nextLine();
hours[counter] = Integer.parseInt(inputString);
}//endfor

counter = 0;// reset counter here
for (totalHours = 0; counter < 5; counter++) {
totalHours += hours[counter];
if (totalHours > 40) {
overTime = payRate + (payRate / 2);
}//endif
}//end of for loop

if (counter == 5) {
System.out.println(name + " " + id + " $" + payRate + "/hour");
avgHours = totalHours / counter;
totalPay = totalHours * payRate + overTime;
System.out.println("Average Hours: " + avgHours);
System.out.println("Total pay: " + totalPay);
System.out.println("Total Hours: " + totalHours);
System.out.println("Overtime ($): " + overTime);
}//end of if