int n;
try {
    n = Integer.parseInt(args[0]);
catch (NumberFormatException e) {
    System.out.println("Your error message ");
     return; // make sure the program cannot continue to execute
}