String employeeNumber = keyboard.next();
Boolean works = true;
for(int a = 0; a < employeeNumber.length(); a++) {
    if (employeeNumber.charAt(a) == '.' || employeeNumber.charAt(a) == '-'){
        works = false;
    }
}
if(!works) {
    System.out.println("\t Invalid Employee Number.");
    System.out.println("\t Please run the program again.");
    System.out.println("Thank you for using \"TEMPLE HUMAN RESOURCES\"");
    System.exit(0);
}