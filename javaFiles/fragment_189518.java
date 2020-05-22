private static Map<Integer, Integer> readInventory(File file) throws IOException {
    var inventory = new HashMap<Integer, Integer>();
    try (var lineScanner = new Scanner(file)) {
        while (lineScanner.hasNextLine()) {
            // we assume each item is on it's own line
            var line = lineScanner.nextLine();
            try (var itemScanner = new Scanner(line)) {
                var no = itemScanner.nextInt();
                var amount = itemScanner.nextInt();
                if (inventory.put(no, amount) != null) {
                    // a more specific exception such as InventoryException might be better
                    throw new RuntimeException("Duplicate item in inventory file");
                }
            }
        }
    }
    return inventory;
}