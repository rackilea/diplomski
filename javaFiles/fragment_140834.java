BinaryTree<Integer> tree = ...
tree.add(1);
tree.add(2);
tree.add("three"); // <-- Syntax error, compiler would fail.
...
Integer first = tree.getFirst();
Integer last = tree.getLast();