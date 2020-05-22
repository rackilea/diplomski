public Node item(int index) {
     if (index < 0) {
         return null;
     }

     Node child = getFirstChild();
     while (child != null && index-- > 0) {
         child = child.getNextSibling();
     }
     return child;
 }