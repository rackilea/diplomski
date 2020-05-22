String inputfile = "input.txt";
File filename = new File (inputfile);

Scanner user = new Scanner (System.in);
System.out.println("Please verify file before moving forward.");
String fileverify = user.nextLine();

if (fileverify.equals("input.txt")) {
    System.out.println("File is available.\n");
}
else {
    System.out.println("Wrong file. Please try again.");
    return;
}

Scanner console = new Scanner(filename);   
ArrayList<String> list = new ArrayList<String>();
while (console.hasNext()) {
    list.add(console.nextLine());
}