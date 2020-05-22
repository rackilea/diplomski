boolean isInt = false;
choice = stdin.nextInt();
while (isInt == false){
int parsed = 0;
try{
   parsed = Integer.parseInt(choice);
}
catch (NumberFormatException nfe){
    System.out.println("Please enter a valid input");
    choice = stdin.nextInt();
}
if (parsed != 0){
    isInt = true;   
}
if (choice != 1 && choice != 2 && choice && != 3){
    System.out.println("Please enter a valid input");
    choice = stdin.nextInt();
}
}