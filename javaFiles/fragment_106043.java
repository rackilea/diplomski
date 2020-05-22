System.out.println("Please enter your name: ");
String empName = Scan.nextLine();
boolean userFound = false;
for (Account a : Accounts) { 
        System.out.println(a);
        if (a.getname().equals(empName)) {
            System.out.println("\nPlease enter your passcode: ");
            String code = Scan.nextLine();
                if (a.check(code) == true) {
                    System.out.println("logged in");
                    userFound = true;
                    break;
                }
            }
    }

if(userFound) {
    login();
} else {
    System.out.println("User not found.");
}