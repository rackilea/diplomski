//case when we delete node having both children.
p2 = rt;
p = rt;

//getting the min of the right child subtree in p variable .
while (p.getLeft() != null)
p = p.getLeft();

p.setLeft(lt);