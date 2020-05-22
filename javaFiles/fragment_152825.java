private Node moveRedLeft(Node h)
    {  // Assuming that h is red and both h.left and h.left.left
       // are black, make h.left or one of its children red.
       colorFlip(h);
       if (isRed(h.right.left))
       { 
          h.right = rotateRight(h.right);

          h = rotateLeft(h);
          colorFlip(h);

          if (isRed(h.right.right) )
             h.right = rotateLeft(h.right);
       }
      return h;
    }