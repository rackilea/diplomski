// Check for correct header
if (!message.startsWith("PABUSOG")) {
    return;
}

// split by whitespaces
String[] items = message.split("\\s+");
// skip header and iterate over remaining items
for (String item : Arrays.asList(items).subList(1, items.length)) {
    // split each item by / or ,
    String[] foodQuantity = item.split("[/,]");
    assert foodQuantity.length == 2;

    String food = foodQuantity[0];
    String quantity = foodQuantity[1];

    System.out.println(food + " -- " + quantity);
}