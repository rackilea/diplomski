Scanner userInput = new Scanner(System.in);
File passwordFile = new File("passwordfile.txt");
//this is where the password is stored.
Scanner passwordScanner = new Scanner(passwordFile);
//this is how you read the file.
String password = passwordScanner.next();
//password has been read.