commandLine = console.readLine();
System.out.println("Entered command text:  " + commandLine);
System.out.print  ("Entered command bytes: ");
for (byte b : commandLine.getBytes())
    System.out.print(b + ", ");
System.out.println();