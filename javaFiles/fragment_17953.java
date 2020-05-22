//String input=""; // this line is obsolete
scan = new Scanner(file);
scan.nextLine();
while(scan.hasNextLine()) {
    final String input = scan.nextLine(); // read the line after the check (to make sure there is a line available)
    String[] countryNames = input.split(",");
    //int a = Integer.parseInt(countryNames[1]);
    System.out.println(countryNames[0]);
    //System.out.println(a);
}