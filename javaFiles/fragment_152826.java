private Node fixUp(Node h)
{
   if (isRed(h.right))
   {      
      if (species == TD234 && isRed(h.right.left))
         h.right = rotateRight(h.right);
      h = rotateLeft(h);
   }

   if (isRed(h.left) && isRed(h.left.left))
      h = rotateRight(h);

   if (species == BU23 && isRed(h.left) && isRed(h.right))
      colorFlip(h);

   return setN(h);
}