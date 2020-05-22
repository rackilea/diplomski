Scanner scanPhone = new Scanner(scanFile.nextLine());
// this is causing your error. scanPhone is ultimately just a one line String

// this line will be found
String phoneType = scanPhone.nextLine();

// this line won't because scanPhone is only one line
String number = scanPhone.nextLine();