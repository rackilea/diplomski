File file = new File(fileName);
Scanner input = new Scanner(file);
List<String> list = new ArrayList<String>();

while (input.hasNextLine()) {
    list.add(input.nextLine());
}