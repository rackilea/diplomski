class Node {
   private volatile Node left, right;

   private static final AtomicReferenceFieldUpdater<Node, Node> leftUpdater =
     AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "left");
   private static AtomicReferenceFieldUpdater<Node, Node> rightUpdater =
     AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "right");

   Node getLeft() { return left; }
   boolean compareAndSetLeft(Node expect, Node update) {
     return leftUpdater.compareAndSet(this, expect, update);
   }
   // ... and so on
 }