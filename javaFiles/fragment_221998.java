public Warehouse readInventoryFile(File inputFile) throws FileNotFoundException {
Warehouse warehouse1 = new Warehouse();
Scanner in = new Scanner(inputFile);

while(in.hasNext()) {
String item = in.nextLine();
int sku = in.nextInt();
double price = in.nextDouble();
int stock = in.nextInt();
String nextLine = in.nextLine();

InventoryItem myItem = new InventoryItem(sku, item, price, stock);
warehouse1.addItem(myItem);
}