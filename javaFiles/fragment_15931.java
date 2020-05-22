MyIntWrapper mir = new MyIntWrapper();
Tree<MyIntWrapper.MyInteger, String> tree = new Tree();
// Add stuff to the tree
mir.doneAdding();

MyIntWrapper.MyInteger mi = mir.new MyInteger(1);
tree = tree.delete(mi); // Will throw NotAllowedException if add() is called