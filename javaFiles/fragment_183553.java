public static void main(String[] args) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("inputFile.txt"));
        String nextLine = reader.readLine();
        List<Item> listOfItems = new ArrayList<Item>();

        while (nextLine != null) {
            if (!nextLine.equals("\n") && !nextLine.isEmpty()) {
                String manufacturer = nextLine;
                String type = reader.readLine();
                String colour = reader.readLine();
                String price = reader.readLine();

                Item newItem = new Item(manufacturer, type, colour, price);
                listOfItems.add(newItem);
            }
            nextLine = reader.readLine();
        }
        reader.close();
        Collections.sort(listOfItems, new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                return o1.manufacturer.compareTo(o2.manufacturer);
            }
        });            
        PrintWriter writer = new PrintWriter("outputFile.txt");

        for (Item item : listOfItems) {
            writer.println(item.manufacturer);
            writer.println(item.type);
            writer.println(item.colour);
            writer.println(item.price);
            writer.println();
        }
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}