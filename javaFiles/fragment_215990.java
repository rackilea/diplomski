Scanner in = new Scanner(System.in);
out.print("Enter name: ");
String name = in.nextLine();

BufferedReader br = new BufferedReader(new FileReader("name.txt"));
String line;
boolean nameFound = false;
while ((line = br.readLine()) != null) {
    if (line.contains(name)) {
        out.println("Exists");
        nameFound = true;
        break;
}
if (!nameFound) {
    out.println("Does not exist");
}
br.close();