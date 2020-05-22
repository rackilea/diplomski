Scanner sc = new Scanner(System.in);
String line;
while (!(line = sc.nextLine()).isEmpty()) {
    System.out.println("Received line : " + line);
    //textEditor.addString(line);
}
sc.close();

System.out.println("The end");