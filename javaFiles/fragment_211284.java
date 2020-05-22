String xfile = "****";
String input;
String inputArray[];

List<Item> itemList = new ArrayList<Item>();  // to store the list of items

Scanner scan = new Scanner(new BufferedReader(new FileReader(xfile)));
input = scan.nextLine();

while (scan.hasNextLine())
{
    input = scan.nextLine();
    inputArray = input.split(",");

    System.out.println(inputArray[2]);

    // assuming your item number and price are ints
    itemList.add(new Item(inputArray[1], Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[2])));
}