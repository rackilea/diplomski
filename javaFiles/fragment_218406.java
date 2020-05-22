ObjectProperty<Tree> importantTree = new SimpleObjectProperty();
Binding<Color> importantTreesColor = Bindings.createObjectBinding(() -> 
    importantTree.get() == null ? null : importantTree.get().getColor(),
    importantTree);

Tree a = new Tree(Color.RED);
Tree b = new Tree(Color.GREEN);

importantTree.set(a);
System.out.println(importantTreesColor.getValue()); // Prints RED.

importantTree.set(b);
System.out.println(importantTreesColor.getValue()); // Prints GREEN.