String response;
Scanner intInput = new Scanner(System.in);
System.out.print("Enter "+ vName + ": ");
response = intInput.next();
try {
intStore = Integer.parseInt( response );
}
catch (NumberFormatException e) {
    System.out.println("Please enter a whole number only");
}