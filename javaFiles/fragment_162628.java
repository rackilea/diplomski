Scanner scanner = new Scanner(fileName);
while (scanner.hasNextLine()) {
    String fileline = scanner.nextLine();
    String myStringsKey = "myStrings =";
    if(fileline.startsWith(myStringsKey)) {

        String[] values = parseMyStrings(fileline);
        System.out.println(Arrays.toString(values));

    }
}