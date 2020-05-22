System.out.println("Enter a month 1-12: ");
int inputMonth = input.nextInt();

// This will hold our result.
int convertedMonth; 
// Convert January to 13 and February to 14; Zeller's requirement
if (inputMonth == 1){
   convertedMonth = 13;
}
else if (inputMonth == 2){
   convertedMonth = 14;
}
else{
   convertedMonth = inputMonth;
}