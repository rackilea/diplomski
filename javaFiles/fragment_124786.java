Catalog c = new Catalog();

System.out.println("Empty : " + c.toString());

c.addItem(new Item(1, "abc", 2d));
c.addItem(new Item(2, "def", 3d));
c.addItem(new Item(3, "ghi", 4d));

System.out.println("Not empty : " + c.toString());