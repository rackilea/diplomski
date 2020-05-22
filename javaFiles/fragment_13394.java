boolean change;
do {
   change = false;
   Node oldX = null;
   // your for:
   for (Node x = first; x.next != null; x = x.next) {
       if (!correctOrder(x, x.next)) {
            // swap x and x.next, if oldX == null then x == first
            change = true;
       }
       oldX = x;
   }
} while (change);