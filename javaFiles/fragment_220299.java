// Modify item #1
p.items.get(0).fileName = "item11.txt";
p.items.get(0).contentType = "short";

// Create and add a new item
Item item3 = new Item();
item3.fileName = "item3.txt";
item3.contentType = "newtype";
p.items.add(item3);

// Save the modified parameters: 1 line:
JAXB.marshal(p, new File("params-out.xml"));